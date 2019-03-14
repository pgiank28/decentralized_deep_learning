from __future__ import print_function

class SparkContext(object):
    def __init__(self):
        self.master = 0

    def run(self):
        self.master = 1

