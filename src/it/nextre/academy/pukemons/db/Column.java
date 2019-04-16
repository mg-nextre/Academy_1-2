package it.nextre.academy.pukemons.db;

public class Column <T> {

    private String name;
    private T value;
    //private String typeString;
    private Integer length;
    private Boolean signed;
    private Boolean nullAllowance;
    private Boolean fillZero;
    private Boolean unique;
    private Boolean primaryKey;
    private Boolean foreignKey;

    /*GESTIONE DELL'AUTO_INCREMENT E DELLE KEY / PRIMARY KEY*/

    //private Column<N,T,L>[] columns;

    public Column(String name, T value){
        this.name = name;
        this.value = value;
    }

    public Column(String name, T value, Integer length, Boolean signed, Boolean nullAllowance, Boolean fillZero, Boolean unique, Boolean primaryKey, Boolean foreignKey){
        //this.typeString = UtilityDB.getAllowedType(value.getClass());
        this.name = name;
        this.value = value;
        this.length = length;
        this.signed = signed;
        this.nullAllowance = nullAllowance;
        this.fillZero = fillZero;
        this.unique = unique;
        this.primaryKey = primaryKey;
        this.foreignKey = foreignKey;
        /*BISOGNA FARE UN CONTROLLO PER RESTITUIRE I VALORI AMMESSI DEI TIPI DELLE COLONNE SU MYSQL*/
    }

    public String getUnique() {
        return unique ? "UNIQUE" : "";
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public String getPrimaryKey() {
        return primaryKey ? "PRIMARY KEY" : "";
    }

    public void setPrimaryKey(Boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Boolean getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(Boolean foreignKey) {
        this.foreignKey = foreignKey;
    }

    public String getValue(){
        return value.toString();
    }

    public String getValueForDB() {
        return UtilityDB.getAllowedType(value.getClass());
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getTypeString() {
        return typeString;
    }*/

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    /*SINCE mySQL ACCEPTS SIGNED & UNSIGNED WE MUST RETURN A STRING*/
    public String getSigned() {
        if(value instanceof Number){
            return signed ? "SIGNED" : "UNSIGNED";
        }else{
            return "";
        }
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }

    /*SINCE mySQL ACCEPTS NULL & NOT NULL WE MUST RETURN A STRING*/
    public String getNullAllowance() {
        return nullAllowance ? "NULL" : "NOT NULL";
    }

    public void setNullAllowance(Boolean nullAllowance) {
        this.nullAllowance = nullAllowance;
    }

    /*SINCE mySQL ACCEPTS ZEROFILL WE MUST RETURN A STRING*/
    public String getFillZero() {
        return fillZero ? " ZEROFILL" : "";
    }

    public void setFillZero(Boolean fillZero) {
        this.fillZero = fillZero;
    }
}//end class
