package com.example.microserviciofichasmedicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.microserviciofichasmedicas.model.ConsultaMedicaEntity;
import com.example.microserviciofichasmedicas.model.FichasMedicasEntity;
import com.example.microserviciofichasmedicas.model.TurnosAtencionMedicaEntity;
import com.example.microserviciofichasmedicas.model.UsuarioEntity;

public interface ConsultaMedicaRepositoryJPA extends org.springframework.data.jpa.repository.JpaRepository<ConsultaMedicaEntity, Integer>,JpaSpecificationExecutor<ConsultaMedicaEntity> {
    // List<FichasMedicasEntity> findByIdPaciente(int idPaciente);
    // @Query(value="SELECT cm.codigo_ficha_medica,cm.numero_ficha,c.nombre,t.nombre,m.nombres,e.nombre FROM consultas_medicas cm"+
    // " INNER JOIN turnos_atencion_medica tam ON tam.id_turno_atencion_medica =cm.id_turno_atencion_medica"+
    // " INNER JOIN consultorios c ON tam.id_consultorio =c.id_consultorio"+
    // " INNER JOIN turnos t  ON tam.id_turno =t.id_turno"+
    // " INNER JOIN usuarios m ON tam.id_medico =m.id_usuario"+
    // " INNER JOIN especialidades e ON c.id_especialidad=e.id_especialidad "+
    // " WHERE cm.id_consulta_medica =?1",nativeQuery=true)
    // List<Object> obtenerDetalleFichaMedica(int idFichaMedica);
    // @Query(value="SELECT cm.id_consulta_medica,cm.codigo_ficha_medica,cm.numero_ficha,c.nombre,t.nombre,e.nombre,CONCAT(m.nombres,' ',m.apellido_paterno,' ',m.apellido_materno),tam.fecha FROM consultas_medicas cm "+
    // "INNER JOIN turnos_atencion_medica tam ON tam.id_turno_atencion_medica =cm.id_turno_atencion_medica "+
    // "INNER JOIN turnos t  ON tam.id_turno =t.id_turno "+
    // "INNER JOIN usuarios m ON tam.id_medico =m.id_usuario "+
    // "INNER JOIN consultorios c ON tam.id_consultorio =c.id_consultorio "+
    // "INNER JOIN especialidades e ON c.id_especialidad  =e.id_especialidad  "+
    // "INNER JOIN usuarios p ON p.id_usuario = cm.id_paciente "+
    // "WHERE tam.id_medico = ?1"
    // ,nativeQuery=true)
    // List<Object> obtenerFichasMedicasPorIdMedico(int idMedico);
    // @Query(value="SELECT cm.id_consulta_medica,cm.codigo_ficha_medica,cm.numero_ficha,c.nombre,t.nombre,e.nombre,CONCAT(p.nombres,' ',p.apellido_paterno,' ',p.apellido_materno),tam.fecha FROM consultas_medicas cm "+
    // "INNER JOIN turnos_atencion_medica tam ON tam.id_turno_atencion_medica =cm.id_turno_atencion_medica "+
    // "INNER JOIN turnos t  ON tam.id_turno =t.id_turno "+
    // "INNER JOIN usuarios m ON tam.id_medico =m.id_usuario "+
    // "INNER JOIN consultorios c ON tam.id_consultorio =c.id_consultorio "+
    // "INNER JOIN especialidades e ON c.id_especialidad  =e.id_especialidad  "+
    // "INNER JOIN usuarios p ON p.id_usuario = cm.id_paciente "+
    // "WHERE cm.id_paciente = ?1"
    // ,nativeQuery=true)
    // List<Object> obtenerFichasMedicasPorIdPaciente(int idPaciente);
    List<ConsultaMedicaEntity> findByPaciente(UsuarioEntity paciente);
    // @Query(value="SELECT cm.codigo_ficha_medica,cm.numero_ficha,c.nombre,t.nombre,m.nombres,e.nombre FROM consultas_medicas cm"+
    // " INNER JOIN turnos_atencion_medica tam ON tam.id_turno_atencion_medica =cm.id_turno_atencion_medica"+
    // " INNER JOIN consultorios c ON tam.id_consultorio =c.id_consultorio"+
    // " INNER JOIN turnos t  ON tam.id_turno =t.id_turno"+
    // " INNER JOIN usuarios m ON tam.id_medico =m.id_usuario"+
    // " INNER JOIN especialidades e ON c.id_especialidad=e.id_especialidad "+
    // " WHERE cm.id_consulta_medica =?1",nativeQuery=true)
    // List<Object> obtenerDetalleFichaMedica(int idFichaMedica);
    @Query(value="SELECT cm FROM ConsultaMedicaEntity cm "+
    "JOIN cm.turnoAtencionMedica tam "+
    "JOIN tam.medico m "+
    "WHERE m.idUsuario = ?1")
    List<ConsultaMedicaEntity> obtenerFichasMedicasPorIdMedico(int idMedico);

    List<ConsultaMedicaEntity> findAllByTurnoAtencionMedica(TurnosAtencionMedicaEntity turnosAtencionMedicaEntity);
    // @Query(value="SELECT cm.id_consulta_medica,cm.codigo_ficha_medica,cm.numero_ficha,c.nombre,t.nombre,e.nombre,CONCAT(p.nombres,' ',p.apellido_paterno,' ',p.apellido_materno),tam.fecha FROM consultas_medicas cm "+
    // "INNER JOIN turnos_atencion_medica tam ON tam.id_turno_atencion_medica =cm.id_turno_atencion_medica "+
    // "INNER JOIN turnos t  ON tam.id_turno =t.id_turno "+
    // "INNER JOIN usuarios m ON tam.id_medico =m.id_usuario "+
    // "INNER JOIN consultorios c ON tam.id_consultorio =c.id_consultorio "+
    // "INNER JOIN especialidades e ON c.id_especialidad  =e.id_especialidad  "+
    // "INNER JOIN usuarios p ON p.id_usuario = cm.id_paciente "+
    // "WHERE cm.id_paciente = ?1"
    // ,nativeQuery=true)
    // List<ConsultaMedicaEntity> obtenerFichasMedicasPorIdPaciente(int idPaciente);
}