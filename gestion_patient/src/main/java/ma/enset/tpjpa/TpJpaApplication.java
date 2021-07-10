package ma.enset.tpjpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.enset.tpjpa.entities.Patient;
import ma.enset.tpjpa.repositories.PatientRepository;
//import java.util.List;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Hatim",new Date(),false));
		patientRepository.save(new Patient(null,"Hassan",new Date(),true));
		patientRepository.save(new Patient(null,"Imane",new Date(),false));
		patientRepository.save(new Patient(null,"Rania",new Date(),true));
		patientRepository.save(new Patient(null,"Tim",new Date(),true));
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("*******************************");
		//With pagination we can SLICE sour data to pages and specify number of objects in each page
		//Since Page extends Slice<>
		Page<Patient> patients = patientRepository.findAll(PageRequest.of(2, 2)) ;
		patients.forEach(p->{
			System.out.println(p);
		});
		System.out.println("*******************************");
		/*Page<Patient> patients2 = patientRepository.findByNameContains("a", PageRequest.of(1, 3));
		patients2.forEach(p->{
			System.out.println(p);
		});*/
	}

}
