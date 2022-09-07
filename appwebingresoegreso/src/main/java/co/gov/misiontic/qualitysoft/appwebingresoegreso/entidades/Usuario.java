package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.Util.EnumRol;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "clave")
    private String clave;
    //@ManyToOne
    @Column(name = "rol", nullable = false)
    @Enumerated(value=EnumType.STRING)
    private EnumRol rol;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @OneToMany
    @JoinColumn(name = "movimiento_id")
    private List<MovimientoDinero> movimientos;
    @Column(name = "fecha")
    private LocalDate fecha;
    public Usuario() {
    }
    public Usuario(String nombre, String imagen, String correo, String telefono, String clave, EnumRol rol, Empresa empresa ) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.correo = correo;
        this.telefono = telefono;
        this.clave = clave;
        this.rol = rol;
        this.empresa = empresa;
        this.fecha = LocalDate.now();
    }
}