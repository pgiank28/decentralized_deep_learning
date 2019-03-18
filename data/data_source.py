from pyspark import SparkConf, SparkContext
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, FloatType

import pandas as pd
import numpy as np
import configparser

class DataSource:
    def __init__(self):
       
        conf = SparkConf().setAppName("DDLSpark").setMaster("spark://localhost:7077")
        self.sc = SparkContext(conf=conf)
        self.spark = SparkSession.builder.config(conf=conf).getOrCreate()

