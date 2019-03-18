from __future__ import print_function
from pyspark.context import SparkContext
from pyspark.conf import SparkConf
from pyspark.files import SparkFiles
from pyspark.traceback_utils import CallSite, first_spark_call
from pyspark.profiler import BasicProfiler
from pyspark.serializers import PickleSerializer

import os
import sys
import shutil

class DDLSparkContext(SparkContext):
    def __init__(self,gateway=None,conf=None):
        self.current_call = first_spark_call()
        """
        Return a CallSite representing the first Spark call in the current call stack.
        CallSite = namedtuple("CallSite", "function file linenum")
        """

        SparkContext._ensure_initialized(self,gateway=gateway,conf=conf)
        """
        Checks whether a SparkContext is initialized or not.
        Throws error if a SparkContext is already running.
        """


        try:
            self.set_spark_context(master=None,appName=None,sparkHome=None,pyFiles=None,
            environment=None,batchSize=0,serializer=PickleSerializer(),conf=None,
            jsc=None,profiler_cls=BasicProfiler)
            
        except:
            # If an error occurs, clean up in order to allow future SparkContext creation:
            self.stop()
            raise

    def set_spark_context(self,master, appName, sparkHome, pyFiles, environment, batchSize, serializer,
                          conf, jsc, profiler_cls):
        self._do_init(master, appName, sparkHome, pyFiles, environment, batchSize, serializer,
                          conf, jsc, profiler_cls)


class test:
    def __init__(self):
        sc = mySparkContext(None,None)





