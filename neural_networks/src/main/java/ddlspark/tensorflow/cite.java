package ddlspark.tensorflow;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.tensorflow.*;

public class cite{

    private Dataset<Row> streaming_input;
    public cite(Dataset<Row> df){
        this.streaming_input = df;
    }
}
