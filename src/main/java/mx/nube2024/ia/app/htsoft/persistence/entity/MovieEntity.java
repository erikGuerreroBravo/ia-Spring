package mx.nube2024.ia.app.htsoft.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerators;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="peliculas")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer duracion;
    private String genero;
    private LocalDate fechaEstreno;
    private BigDecimal clasificacion;
    private String estado;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public BigDecimal getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(BigDecimal clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
