package ma.bougattaya.projet_cinema.daoRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.bougattaya.projet_cinema.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
