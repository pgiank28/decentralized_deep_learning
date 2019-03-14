from __future__ import print_function
import os
import sys
import shutil

class SparkContext(object):
    def __init__(self):
        self.master = 0

    def run(self):
        self.master = 1


class sparkGet(SparkContext):
    def __init__(self,conf):
        self.status = 0
    
    def conf(self):
        self.status = 1

print("hi")
g = sparkGet(2)
g.conf();
