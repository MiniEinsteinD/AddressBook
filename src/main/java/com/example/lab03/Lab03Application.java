package com.example.lab03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.Random;


@SpringBootApplication
public class Lab03Application {
	private static final Logger log = LoggerFactory.getLogger(Lab03Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Lab03Application.class, args);
	}
	@Bean
	public CommandLineRunner demo(AddressBookRepository addressBookRepositoryrepository, BuddyInfoRepository buddyInfoRepository) {
		return (args) -> {
			Random random = new Random();

			BuddyInfo[] buddyInfos = new BuddyInfo[] {
					new BuddyInfo(1L,"Danny", "01"),
					new BuddyInfo(2L,"Jay", "02"),
					new BuddyInfo(3L,"Beau", "03"),
					new BuddyInfo(4L,"Sammy", "06"),
					new BuddyInfo(5L,"Ray", "07"),
					new BuddyInfo(6L,"Zamoe", "08"),
			};

			AddressBook[] addressBooks = new AddressBook[] {
					new AddressBook("Daniah"),
					new AddressBook("Za"),
					new AddressBook("Umni"),
					new AddressBook("Lerhit")
			};

			int randomNumber = random.nextInt(addressBooks.length);

			for(BuddyInfo buddyInfo: buddyInfos) {
				addressBooks[randomNumber].addBuddy(buddyInfo);
				randomNumber = random.nextInt(addressBooks.length);
			}

			// save a few AddressBooks
			for (AddressBook addressBook : addressBooks) {
				addressBookRepositoryrepository.save(addressBook);
			}

			// save a few BuddyInfo
			for (BuddyInfo buddyInfo : buddyInfos) {
				buddyInfoRepository.save(buddyInfo);
			}


			// fetch all BuddyInfo
			log.info("BuddyInfo found with findAll():");
			log.info("-------------------------------");
			for (BuddyInfo buddyInfo: buddyInfoRepository.findAll()) {
				log.info(buddyInfo.toString());
			}
			log.info("");

			// fetch an individual BuddyInfo by ID
			Optional<BuddyInfo> buddyInfo = buddyInfoRepository.findById(6L);
			log.info("buddyInfo found with findById(6L):");
			log.info("--------------------------------");
			log.info(buddyInfo.toString());
			log.info("");

			// fetch all AddressBooks
			log.info("AddressBooks found with findAll():");
			log.info("-------------------------------");
			for (AddressBook addressBook : addressBookRepositoryrepository.findAll()) {
				log.info(addressBook.toString());
			}
			log.info("");

			// fetch an individual AddressBook by ID
			AddressBook addressBook = addressBookRepositoryrepository.findByOwner("Daniah");
			log.info("AddressBook found with findById(Daniah):");
			log.info("--------------------------------");
			log.info(addressBook.toString());
			log.info("");

		};
	}

}
