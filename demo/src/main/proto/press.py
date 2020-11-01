import paho.mqtt.client as mqtt
import json,time
import random
import threading


HOST = "118.113.164.51"
PORT = 25703
# HOST = "127.0.0.1"
# PORT = 30003
# HOST = "39.100.14.20"
# PORT = 30003

def on_connect(client, userdata, flags, rc):
    print("Connected with result code "+str(rc))
    client.subscribe("test")

def on_message(client, userdata, msg):
    print(msg.topic+" "+msg.payload.decode("utf-8"))



def pub_loop(client, topic, data):
        while True:
            F1 = random.randint(0, 1)
            F2 = random.randint(1000, 9000)
            F3 = random.randint(0, 1)
            F4 = random.randint(0, 1)
            F5 = random.randint(1000, 9000)

            #data['request']['value'] = str('Device_Temperature:' + str(F1) + ',Device_Pressure:' + str(F2) +',Device_Flow:'+ str(F3))
            data['request']['value'] = str(F1)
            data['request']['metadata']['Device_FX3U_Status'] = str(F1)
            data['request']['metadata']['Device_Pluse_Counts'] = str(F2)
            data['request']['metadata']['Device_Foreward_Status'] = str(F3)
            data['request']['metadata']['Device_Reversal_Status'] = str(F4)
            data['request']['metadata']['Device_Temperature'] = str(F5)


            print(data)
            payload = json.dumps(data)

            client.publish(topic, payload=payload, qos=0)
            time.sleep(0.5)


if __name__ == '__main__':
        client = mqtt.Client()
        client.on_connect = on_connect
        client.on_message = on_message
        client.connect(HOST, PORT, 600)  # 600为keepalive的时间间隔

        #topic = "SiteWhere/default/input/json"
        topic = "SiteWhere/Yinh/input/json"

        data_measurement = {
          "type": "DeviceMeasurement",
          "originator": "device",
          #"deviceToken": "31152-RASPBERRYPI-2249802",
          "deviceToken": "1100",
          "request": {
            "name": "Device_Temperature",
            "value": 10.23,
            "updateState": "true",
            "eventDate": "",
            "metadata": {
              "Device_FX3U_Status": 1,
              "Device_Pluse_Counts": 1000,
              "Device_Foreward_Status": 1,
              "Device_Reversal_Status": 1,
              "Device_Temperature": 12.31
            }
          }
        }

        def run(n):
            print("task:", n)
            pub_loop(client, topic, data_measurement)

        t_objs = []
        for i in range(1):
            t = threading.Thread(target=run, args=("t-{0}".format(i),))
            t.start()
            t_objs.append(t)
        for t in t_objs:
            t.join()