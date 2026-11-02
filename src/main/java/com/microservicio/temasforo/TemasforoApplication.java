package com.microservicio.temasforo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservicio.temasforo.models.Comentario;
import com.microservicio.temasforo.models.Publicacion;
import com.microservicio.temasforo.repository.ComentarioRepository;
import com.microservicio.temasforo.repository.PublicacionRepository;
import com.microservicio.temasforo.service.PublicacionService;

@SpringBootApplication
public class TemasforoApplication {

	@Autowired
	PublicacionService publicacionService;

	public static void main(String[] args) {
		SpringApplication.run(TemasforoApplication.class, args);
	}

@Bean
CommandLineRunner initData(PublicacionRepository publiRepo, ComentarioRepository comRepo) {
    return args -> {

        LocalDate fecha = LocalDate.now();

        if (publiRepo.count() == 0) {

            List<Publicacion> publicaciones = List.of(
                new Publicacion("Cambio Climatico", "Sera cierto que el cambio climatico.....", fecha, true, 1L),
                new Publicacion("Campeonato 2da Division", "El campeonato de segunda division en chile...", fecha, true, 1L),
                new Publicacion("Informatica y mas", "Ultimos avances en ..", fecha, true, 1L)
            );
            publiRepo.saveAll(publicaciones);

            if (comRepo.count() == 0) {
                List<Comentario> comentarios = List.of(
                    new Comentario("YO CREO QUE ....EL CAMBIO CLIMATICO", publicaciones.get(0), fecha, 1L),
                    new Comentario("NO CREO QUE EL CAMBIO CLIMATICO", publicaciones.get(0), fecha, 1L),
                    new Comentario("EFECTICAMENTE LA INFORMATICA", publicaciones.get(2), fecha, 1L)
                );
                comRepo.saveAll(comentarios);
            }
        }
    };
}

}
