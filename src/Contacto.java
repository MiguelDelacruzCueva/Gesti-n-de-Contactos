class Contacto {
    private String nombre;
    private String telefono;
    private String correo;

    // Constructor para inicializar un contacto
    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Métodos para obtener información del contacto
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    // Metodo para mostrar la información del contacto
    // en este caso el Override modifica el metodo anterior para poder perzonalizar el return
    // de la siguiente manera
    @Override
    public String toString() {

        return "Nombre: " + nombre + " | Teléfono: " + telefono + " | Correo: " + correo;
    }
}