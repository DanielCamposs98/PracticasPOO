

//Clase OrderedPair implementa la interfaz Pair
public class OrderedPair<K,V> implements Pair<K, V>{
    //Atributos 
    private K key;
    private V value;
    //Constructor
    public OrderedPair(K key,V value){
        this.key=key;
                this.value=value;
    }
    //Metodos implementados de la interfaz Pair
      @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    //Instancias de la clase OrderedPair
    Pair<String, Integer> p1 = new OrderedPair<String,Integer>("Daniel", 1);
    Pair<String, String> p2 = new OrderedPair<String,String>("Campos,", "Medina");

    //Instancias de OrderedPair utilizando lo dicho en el apartado El Diamante, notacion diamante.
    OrderedPair<String, Integer> q1 = new OrderedPair<>("Even", 9);
    OrderedPair<String, String> q2= new OrderedPair<>("Hello","World");
    
    //Instancia de OrderedPair con parametros de tipo con un tipo parametrizado
    OrderedPair<String,Box<Integer>> p= new OrderedPair<>("Primes", new Box<Integer>());  
}

