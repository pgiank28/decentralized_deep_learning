# DDLSpark
## Abstract
Deep learning training framework,for Apache Spark. With this protocol,we achieve great results regarding both the corectness and the velocity.

## Installation
Apache Spark 2.4.2 or above required.The library is simple API that allows to train a Neural Network efficiently.
It supports Tensorflow and Spark MLlib model training.
### Step 1
Install the PyPi library </br>
```pip install DDLSpark```
### Step 2
Import the library to your main PySpark program </br>
```Import DDLSpark as dd```


## Network communication
An RPC protocol is used,based on the fundamental netty protocol of Spark.The main change compared to Netty,is that our protocol is implemented and can handle spontaneously arriving updates without communication between parent and children nodes if not necessary.

## Training of local models
Tensorflow and Spark MLlib models are supported.Each node requires TF local installation.

