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
        F1 = round(random.uniform(-180, 180),2)
        F2 = round(random.uniform(-90, 90),2)
        F3 = round(random.uniform(-1000, 8000),2)


        #data['request']['value'] = str('Device_Temperature:' + str(F1) + ',Device_Pressure:' + str(F2) +',Device_Flow:'+ str(F3))
        data['request']['Device_Latitude'] = str(F1)
        data['request']['Device_Longitude'] = str(F2)
        data['request']['Device_Elevation'] = str(F3)

        print(data)
        payload = json.dumps(data)

        client.publish(topic, payload=payload, qos=0)
        time.sleep(1)


if __name__ == '__main__':
    client = mqtt.Client()
    client.on_connect = on_connect
    client.on_message = on_message
    client.connect(HOST, PORT, 600)  # 600为keepalive的时间间隔

    #topic = "SiteWhere/default/input/json"
    #topic = "SiteWhere/Yinh/input/json"
    topic = "SiteWhere/lany/input/json"

    data_measurement = {
        "type":"DeviceLocation",
        "originator":"device",
        "deviceToken": "1102",
        "request":{
            "Device_Latitude":"33.75",
            "Device_Longitude":"-84.39",
            "Device_Elevation":"1",
            "updateState": "true",
            "eventDate":""
        }
    }

    def run(n):
        print("task:", n)
        pub_loop(client, topic, data_measurement)

    t_objs = []
    for i in range(2):
        t = threading.Thread(target=run, args=("t-{0}".format(i),))
        t.start()
        t_objs.append(t)
    for t in t_objs:
        t.join()