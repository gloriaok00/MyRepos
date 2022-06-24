#/bin/sh
rm -f ca.*
rm -f emqx.*
rm -f client.*
# 生成自签名的CA key和证书
openssl genrsa -out ca.key 2048
openssl req -x509 -new -nodes -key ca.key -sha256 -days 3650 -out ca.pem -subj "/C=CN/ST=Jiangsu/L=Suzhou/O=XXX/CN=SelfCA"
#openssl req -x509 -new -nodes -key ca.key -sha256 -days 3650 -out ca.pem
 
# 生成服务器端的key和证书
openssl genrsa -out emqx.key 2048
openssl req -new -key ./emqx.key -config openssl.cnf -out emqx.csr
openssl x509 -req -in ./emqx.csr -CA ca.pem -CAkey ca.key -CAcreateserial -out emqx.pem -days 3650 -sha256 -extensions v3_req -extfile openssl.cnf
 
 
# 生成客户端key和证书
openssl genrsa -out client.key 2048
openssl req -new -key client.key -out client.csr -subj "/C=CN/ST=Jiangsu/L=Suzhou/O=XXX/CN=client"
openssl x509 -req -days 3650 -in client.csr -CA ca.pem -CAkey ca.key -CAcreateserial -out client.pem
 
 