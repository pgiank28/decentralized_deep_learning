from pyspark.ml.wrapper import JavaEstimator, JavaModel, JavaWrapper
from pyspark.ml.common import inherit_doc
from data.data_source import DataSource

@inherit_doc
class basic_coord(JavaEstimator,JavaMLWritable,JavaMLReadable):

    @keyword_only
    def __init__(self):
        src = DataSource()

def if __name__ == "__main__":
    src = DataSource()

