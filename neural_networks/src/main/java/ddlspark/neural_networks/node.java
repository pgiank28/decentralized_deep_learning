package ddlspark.neural_networks;
import ddlspark.neural_networks.Stream;

public enum Type{
	PERCEPTRON,
	SIGMOID,
	CONVOLUTION
}

public class node{
	private Type node_type;
	private int num_of_inputs;
	private Stream output;
	private Stream inputs[];
	private long weights[];
	private long biases[];
}
