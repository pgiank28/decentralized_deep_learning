import org.apache.sql.Dataset;
import org.apache.sql.Row;
import org.apache.sql.SparkSession;
import org.apache.java.api.JavaSparkContext;
import org.apache.spark.ml.classification.LinearSVC;
import org.apache.spark.ml.classification.LinearSVCModel;

public class neural_network{
    public void main(String [] args){
        SparkSession spark = SparkSession
        .builder()
        .appName("NeuralNetworkTraining")
        .getOrCreate();
  
        Dataset<Row> training = spark.read.format("libsvm")
        .load("/usr/local/spark/data/mllib/sample_libsvm_data.txt");

        JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext()); 
        LinearSVC lsvc = new LinearSVC()
        .setMaxIter(10)
        .setRegParam(0.1);

    // Fit the model
        LinearSVCModel lsvcModel = lsvc.fit(training);

    // Print the coefficients and intercept for LinearSVC
        System.out.println("Coefficients: "
      + lsvcModel.coefficients() + " Intercept: " + lsvcModel.intercept());
    // $example off$

        spark.stop();

    }
}
