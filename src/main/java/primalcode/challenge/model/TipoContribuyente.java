package primalcode.challenge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente")
    private Integer idTipoContribuyente;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "estado")
    private boolean estado;

    public TipoContribuyente() {
    }
    public TipoContribuyente(int i, String s, boolean b) {
    }

    public Integer getIdTipoContribuyente() {
        return idTipoContribuyente;
    }

    public void setIdTipoContribuyente(Integer idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
