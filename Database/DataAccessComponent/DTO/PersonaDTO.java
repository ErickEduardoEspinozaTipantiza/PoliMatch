package DataAccessComponent.DTO;

public class PersonaDTO {
    private int idPersona;
    private int idPersonaRol;
    private int idPersonaSexo;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String correo;
    private String observacion;
    private String estado;
    private String fechaCrea;
    private String fechaModifica;
    private String rutaImagen;

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public PersonaDTO(int idPersona, int idPersonaRol, int idPersonaSexo, String nombre, String apellido, String fechaNacimiento, String correo, String observacion, String estado, String fechaCrea, String fechaModifica, String rutaImagen) {
        this.idPersona = idPersona;
        this.idPersonaRol = idPersonaRol;
        this.idPersonaSexo = idPersonaSexo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.observacion = observacion;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
        this.rutaImagen = rutaImagen;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersonaRol() {
        return idPersonaRol;
    }

    public void setIdPersonaRol(int idPersonaRol) {
        this.idPersonaRol = idPersonaRol;
    }

    public int getIdPersonaSexo() {
        return idPersonaSexo;
    }

    public void setIdPersonaSexo(int idPersonaSexo) {
        this.idPersonaSexo = idPersonaSexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "\n" + getClass().getName() +
                "\nIdPersona         : " + getIdPersona() +
                "\nIdPersonaRol      : " + getIdPersonaRol() +
                "\nIdPersonaSexo     : " + getIdPersonaSexo() +
                "\nNombre            : " + getNombre() +
                "\nApellido          : " + getApellido() +
                "\nFechaNacimiento   : " + getFechaNacimiento() +
                "\nCorreo            : " + getCorreo() +
                "\nObservacion       : " + getObservacion() +
                "\nEstado            : " + getEstado() +
                "\nFechaCrea         : " + getFechaCrea() +
                "\nFechaModifica     : " + getFechaModifica() +
                "\nRutaImagen        : " + getRutaImagen();
    }
}