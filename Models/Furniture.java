package Models;

public class Furniture
 {

    //#region Private Properties
    
    private static int    _id;
    private static String _sKU;
    private static String _name;
    private static String _type;
    private static String _color;
    private static double _price;
    private static int _quantity;
    private static Furniture furniture_instance = null;

    ////#endregion


    //#region Constructors

    public static Furniture getInstance()
    {
        if(furniture_instance == null)
            furniture_instance = new Furniture();
        
        return furniture_instance;
    }

    //#endregion

    
    //#region Public Methods

   /**
     * @return String return the _id
     */
    public int get_id() {
        return _id;
    }

    /**
     * @param Id the _id to set
     */
    public void set_id(int id) {
        _id = id;
    }

    /**
     * @return String return the _sKU
     */
    public String get_sKU() {
        return _sKU;
    }

    /**
     * @param sKU the _sKU to set
     */
    public void set_sKU(String sKU) {
        _sKU = sKU;
    }

    /**
     * @return String return the _name
     */
    public String get_name() {
        return _name;
    }

    /**
     * @param _name the _name to set
     */
    public void set_name(String name) {
        _name = name;
    }

    /**
     * @return String return the _type
     */
    public String get_type() {
        return _type;
    }

    /**
     * @param type the _type to set
     */
    public void set_type(String type) {
        _type = type;
    }

    /**
     * @return String return the _color
     */
    public String get_color() {
        return _color;
    }

    /**
     * @param color the _color to set
     */
    public void set_color(String color) {
        _color = color;
    }

    /**
     * @return String return the _price
     */
    public double get_price() {
        return _price;
    }

    /**
     * @param price the _price to set
     */
    public void set_price(double price) {
        _price = price;
    }

    /**
     * @return String return the _remaining
     */
    public int get_quantity() {
        return _quantity;
    }

    /**
     * @param quanitity the _remaining to set
     */
    public void set_quantity(int quantity) {
        _quantity = quantity;
    }

    //#endregion

}