package ddlspark.core;
import org.apache.spark.sql.Dataset;

public class NN_Estimator{
    private int conf;
    public NN_Estimator(int conf){
        this.conf = conf;
    }

    public int getConf(){
        return this.conf;
    }

    public void printConf(){
        System.out.println("This is my conf "+this.conf);
    }
    public void train(Dataset df){

    }
}

