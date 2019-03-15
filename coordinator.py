from pyspark.ml.wrapper import JavaEstimator, JavaModel, JavaWrapper
from pyspark.ml.common import inherit_doc


@inherit_doc
class basic_coord(JavaEstimator,JavaMLWritable,JavaMLReadable):

    @keyword_only
    def __init__(self):
        self.java_obj = self._new_java_obj("deep_learning_distributed", self.uid)
