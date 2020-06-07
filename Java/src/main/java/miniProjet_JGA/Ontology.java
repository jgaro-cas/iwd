package miniProjet_JGA;

import java.util.Date;
import java.util.List;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

public class Ontology {

	private static String namespace;
	
	// Subjects IRIs
	private static IRI person, contact, city, partner, beverage, volunteer, organizer, dicastery, bar, publicBar, limitedBar, location, publicArea, restrictedArea;
	
	// Data property IRIs 
	private static IRI firstName, lastName, 
						phone, address, mail, 
						postalNumber, name,
						employer, partnershipType,
						tshirtSize, birthDate,
						status,
						needsOfVolunteer, needsOfMaterial,
						withAlcool,
						capacity,
						accessLevel, secuGuardNbr;
	
	// Object property IRIs
	private static IRI locatedIn, contactedBy, supplies, sells, manages, worksFor, organizes, situatedIn, isIn;
	
	// Individuals IRIs
	private static IRI Delley, Estavayer,
						ContactJGA, ContactNBE,
						JGA, NBE,
						Water, Beer,
						RCH, ABE,
						MPR, DSC,
						FB, ArtVIP,
						Castle, Lake, Backstage, VIP,
						LakeSide, InnerRun, Back, Lodges;
	
	
	
	public static void main(String[] args) {
		// Generate new repo & value factory
		Repository rep = new SailRepository(new MemoryStore());
		
		// Generate Value Factory
		ValueFactory valFact = rep.getValueFactory();
		
		// Generate namespace
		namespace = "http://cas-dar/iwd/jga/";
		
		// Generate Iri's
		generateIris(rep, valFact);
		
		// Generate RDFS schema
		buildOntology(rep, valFact);
		
		// Generate individuals
		createIndividuals(rep, valFact);
		
		
		// Tests
		RepositoryConnection conn = rep.getConnection();
		RepositoryResult<Statement> comptes = conn.getStatements(VIP, null, null, false);
		while (comptes.hasNext()) {
			Statement stmnt = comptes.next();
			System.out.println(stmnt);
			System.out.println(Character.toString((char)9) + "Subject :" + Character.toString((char)9) + stmnt.getSubject());				
			System.out.println(Character.toString((char)9) + "Predicate :" + Character.toString((char)9) + stmnt.getPredicate());				
			System.out.println(Character.toString((char)9) + "Object :" + Character.toString((char)9) + stmnt.getObject());				
		}
		
	}
	
	public static void generateIris(Repository rep, ValueFactory valFact) {
		
		
		// Generate IRIs
		person	 			= valFact.createIRI(namespace, "person");
		contact	 			= valFact.createIRI(namespace, "contact");
		city	 			= valFact.createIRI(namespace, "city");
		partner	 			= valFact.createIRI(namespace, "partner");
		beverage			= valFact.createIRI(namespace, "beverage");
		volunteer	 		= valFact.createIRI(namespace, "volunteer");
		organizer	 		= valFact.createIRI(namespace, "organizer");
		dicastery	 		= valFact.createIRI(namespace, "dicastery");
		bar	 				= valFact.createIRI(namespace, "bar");
		publicBar	 		= valFact.createIRI(namespace, "publicBar");
		limitedBar	 		= valFact.createIRI(namespace, "limitedBar");
		location	 		= valFact.createIRI(namespace, "location");
		publicArea	 		= valFact.createIRI(namespace, "publicArea");
		restrictedArea		= valFact.createIRI(namespace, "restrictedArea");
		firstName	 		= valFact.createIRI(namespace, "firstName");
		lastName	 		= valFact.createIRI(namespace, "lastName");
		phone	 			= valFact.createIRI(namespace, "phone");
		address	 			= valFact.createIRI(namespace, "address");
		mail 	 			= valFact.createIRI(namespace, "mail");
		postalNumber		= valFact.createIRI(namespace, "postalNumber");
		name	 			= valFact.createIRI(namespace, "name");
		employer	 		= valFact.createIRI(namespace, "employer");
		partnershipType		= valFact.createIRI(namespace, "partnershipType");
		tshirtSize	 		= valFact.createIRI(namespace, "tshirtSize");
		birthDate	 		= valFact.createIRI(namespace, "birthDate");
		status	 			= valFact.createIRI(namespace, "status");
		needsOfVolunteer	= valFact.createIRI(namespace, "needsOfVolunteer");
		needsOfMaterial	 	= valFact.createIRI(namespace, "needsOfMaterial");
		withAlcool	 		= valFact.createIRI(namespace, "withAlcool");
		capacity	 		= valFact.createIRI(namespace, "capacity");
		accessLevel	 		= valFact.createIRI(namespace, "accessLevel");
		secuGuardNbr	 	= valFact.createIRI(namespace, "secuGuardNbr");
		locatedIn	 		= valFact.createIRI(namespace, "locatedIn");
		contactedBy	 		= valFact.createIRI(namespace, "contactedBy");
		supplies	 		= valFact.createIRI(namespace, "supplies");
		sells	 			= valFact.createIRI(namespace, "sells");
		manages	 			= valFact.createIRI(namespace, "manages");
		worksFor	 		= valFact.createIRI(namespace, "worksFor");
		organizes	 		= valFact.createIRI(namespace, "organizes");
		situatedIn	 		= valFact.createIRI(namespace, "situatedIn");
		isIn	 			= valFact.createIRI(namespace, "isIn");
		Delley				= valFact.createIRI(namespace, "Delley");
		Estavayer			= valFact.createIRI(namespace, "Estavayer");
		ContactJGA			= valFact.createIRI(namespace, "ContactJGA");
		ContactNBE			= valFact.createIRI(namespace, "ContactNBE");
		JGA					= valFact.createIRI(namespace, "JGA");
		NBE					= valFact.createIRI(namespace, "NBE");
		Water				= valFact.createIRI(namespace, "Water");
		Beer				= valFact.createIRI(namespace, "Beer");
		RCH					= valFact.createIRI(namespace, "RCH");
		ABE					= valFact.createIRI(namespace, "ABE");
		MPR					= valFact.createIRI(namespace, "MPR");
		DSC					= valFact.createIRI(namespace, "DSC");
		FB					= valFact.createIRI(namespace, "FB");
		ArtVIP				= valFact.createIRI(namespace, "ArtVIP");
		Castle				= valFact.createIRI(namespace, "Castle");
		Lake				= valFact.createIRI(namespace, "Lake");
		Backstage			= valFact.createIRI(namespace, "Backstage");
		VIP					= valFact.createIRI(namespace, "VIP");
		LakeSide			= valFact.createIRI(namespace, "LakeSide");
		InnerRun			= valFact.createIRI(namespace, "InnerRun");
		Back				= valFact.createIRI(namespace, "Back");
		Lodges				= valFact.createIRI(namespace, "Lodges");
	}

	static void buildOntology(Repository rep, ValueFactory valFact) {
		RepositoryConnection conn = rep.getConnection();
		try {
			// Classes
			conn.add(person, RDF.TYPE, RDFS.CLASS);
			conn.add(contact, RDF.TYPE, RDFS.CLASS);
			conn.add(city, RDF.TYPE, RDFS.CLASS);
			conn.add(partner, RDF.TYPE, RDFS.CLASS);
			conn.add(beverage, RDF.TYPE, RDFS.CLASS);
			conn.add(volunteer, RDF.TYPE, RDFS.CLASS);
			conn.add(organizer, RDF.TYPE, RDFS.CLASS);
			conn.add(dicastery, RDF.TYPE, RDFS.CLASS);
			conn.add(bar, RDF.TYPE, RDFS.CLASS);
			conn.add(publicBar, RDF.TYPE, RDFS.CLASS);
			conn.add(limitedBar, RDF.TYPE, RDFS.CLASS);
			conn.add(location, RDF.TYPE, RDFS.CLASS);
			conn.add(publicArea, RDF.TYPE, RDFS.CLASS);
			conn.add(restrictedArea, RDF.TYPE, RDFS.CLASS);
			
			// Subclass
			conn.add(partner, RDFS.SUBCLASSOF, person);
			conn.add(volunteer, RDFS.SUBCLASSOF, person);
			conn.add(organizer, RDFS.SUBCLASSOF, person);
			conn.add(publicBar, RDFS.SUBCLASSOF, bar);
			conn.add(limitedBar, RDFS.SUBCLASSOF, bar);
			conn.add(publicArea, RDFS.SUBCLASSOF, location);
			conn.add(restrictedArea, RDFS.SUBCLASSOF, location);
						
			// Predicates
			conn.add(firstName, RDF.TYPE, RDF.PREDICATE);
			conn.add(lastName, RDF.TYPE, RDF.PREDICATE);
			conn.add(phone, RDF.TYPE, RDF.PREDICATE);
			conn.add(address, RDF.TYPE, RDF.PREDICATE);
			conn.add(mail, RDF.TYPE, RDF.PREDICATE);
			conn.add(postalNumber, RDF.TYPE, RDF.PREDICATE);
			conn.add(name, RDF.TYPE, RDF.PREDICATE);
			conn.add(employer, RDF.TYPE, RDF.PREDICATE);
			conn.add(partnershipType, RDF.TYPE, RDF.PREDICATE);
			conn.add(tshirtSize, RDF.TYPE, RDF.PREDICATE);
			conn.add(birthDate, RDF.TYPE, RDF.PREDICATE);
			conn.add(status, RDF.TYPE, RDF.PREDICATE);
			conn.add(needsOfVolunteer, RDF.TYPE, RDF.PREDICATE);
			conn.add(needsOfMaterial, RDF.TYPE, RDF.PREDICATE);
			conn.add(withAlcool, RDF.TYPE, RDF.PREDICATE);
			conn.add(capacity, RDF.TYPE, RDF.PREDICATE);
			conn.add(accessLevel, RDF.TYPE, RDF.PREDICATE);
			conn.add(secuGuardNbr, RDF.TYPE, RDF.PREDICATE);
			conn.add(locatedIn, RDF.TYPE, RDF.PREDICATE);
			conn.add(contactedBy, RDF.TYPE, RDF.PREDICATE);
			conn.add(supplies, RDF.TYPE, RDF.PREDICATE);
			conn.add(sells, RDF.TYPE, RDF.PREDICATE);
			conn.add(manages, RDF.TYPE, RDF.PREDICATE);
			conn.add(worksFor, RDF.TYPE, RDF.PREDICATE);
			conn.add(organizes, RDF.TYPE, RDF.PREDICATE);
			conn.add(situatedIn, RDF.TYPE, RDF.PREDICATE);
			conn.add(isIn, RDF.TYPE, RDF.PREDICATE);
			
			// Subproperty
			conn.add(isIn, RDFS.SUBPROPERTYOF, situatedIn);
		}finally {
			conn.close();
		}
	}

	static void createIndividuals(Repository rep, ValueFactory valFact) {
		// Generate cities
		createIndividualCity(rep, valFact, Delley, "Delley", 1567);
		createIndividualCity(rep, valFact, Estavayer, "Estavayer-le-Lac", 1470);
		
		// Generate Contacts
		createIndividualContact(rep, valFact, ContactJGA, "Route de Portalban 2", "079 740 11 43", "jerome.garo@free4style.com", Delley);
		createIndividualContact(rep, valFact, ContactNBE, "Route de la Rochette", "079 999 99 99", "nico.baech@free4style.com", Estavayer);
		
		// Generate Organizers
		createIndividualOrganizer(rep, valFact, JGA, "F&B Resp", "Jérôme", "Garo", ContactJGA, FB);
		createIndividualOrganizer(rep, valFact, NBE, "Welcme artrists Resp", "Nico", "Baech", ContactNBE, ArtVIP);
		
		// Generate Beverages
		createIndividualBeverage(rep, valFact, Water, "Valser Classic", false);
		createIndividualBeverage(rep, valFact, Beer, "Cardinal Blonde", true);
		
		// Generate Partners
		createIndividualParter(rep, valFact, RCH, "Chardonnens Boissons", "Richard", "Chardonnens", "Sponsor", Water);
		createIndividualParter(rep, valFact, ABE, "Feldschlöschen", "Alain", "Berlens", "Supplyer", Beer);
		
		// Generate Volunteers
		createIndividualVolunteer(rep, valFact, MPR, "L", "Michael", "Premo", java.sql.Date.valueOf("1985-01-01"), FB);
		createIndividualVolunteer(rep, valFact, DSC, "M", "Damien", "Scheurer", java.sql.Date.valueOf("1986-01-01"), ArtVIP);
		
		// Generate Dicastery
		createIndividualDicastery(rep, valFact, FB, "Truck", 25, Castle, Lake); 
		createIndividualDicastery(rep, valFact, ArtVIP, "Sofa", 3, Backstage, VIP);
		
		// Generate Public Bars
		createIndividualPublicBar(rep, valFact, Castle, "Château", 250, Water, InnerRun);
		createIndividualPublicBar(rep, valFact, Lake, "Lac", 180, Beer, LakeSide);
		
		// Generate Limited Bars
		createIndividualLimitedBar(rep, valFact, Backstage, "Back", 10, Water, Back);
		createIndividualLimitedBar(rep, valFact, VIP, "Loge", 25, Beer, Lodges);
		
		// Generate Public Areas
		createIndividualPublicArea(rep, valFact, LakeSide, "Bordu");
		createIndividualPublicArea(rep, valFact, InnerRun, "Coure intérieure");
		
		// Generate Restricted Area
		createIndividualRestrictedArea(rep, valFact, Back, "Arrière scène", "Badge noir", 5);
		createIndividualRestrictedArea(rep, valFact, Lodges, "Loges", "Badge rouge", 7);
		
		
	}
	
	static void createIndividualCity(Repository rep, ValueFactory valFact, IRI iri, String sName, Integer nPostalNbr) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, city);
			conn.add(iri, name, valFact.createLiteral(sName));
			conn.add(iri, postalNumber, valFact.createLiteral(nPostalNbr));
			
		}finally{
			conn.close();
		}
	}
	
	static void createIndividualContact (Repository rep, ValueFactory valFact, IRI iri, String sAddress, String sPhone, String sMail, IRI iCity) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, contact);
			conn.add(iri, address, valFact.createLiteral(sAddress));
			conn.add(iri, phone, valFact.createLiteral(sPhone));
			conn.add(iri, mail, valFact.createLiteral(sMail));
			conn.add(iri, locatedIn, iCity);
		}finally{
			conn.close();
		}
	}
	
	static void createIndividualOrganizer(Repository rep, ValueFactory valFact, IRI iri, String sStatus, String sFirstName, String sLastName, IRI iContact, IRI iManages) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, organizer);
			conn.add(iri, status, valFact.createLiteral(sStatus));
			conn.add(iri, firstName, valFact.createLiteral(sFirstName));
			conn.add(iri, lastName, valFact.createLiteral(sLastName));
			conn.add(iri, contactedBy, iContact);		
			conn.add(iri, manages, iManages);
		}finally{
			conn.close();
		}
	}

	static void createIndividualBeverage(Repository rep, ValueFactory valFact, IRI iri, String sName, boolean bWithAlcool) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, beverage);
			conn.add(iri, name, valFact.createLiteral(sName));
			conn.add(iri, withAlcool, valFact.createLiteral(bWithAlcool));
		}finally{
			conn.close();
		}
	}
	
	static void createIndividualParter(Repository rep, ValueFactory valFact, IRI iri, String sEmployer, String sFirstName, String sLastName, String sPartnershipType, IRI iSupplies) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, partner);
			conn.add(iri, employer, valFact.createLiteral(sEmployer));
			conn.add(iri, firstName, valFact.createLiteral(sFirstName));
			conn.add(iri, lastName, valFact.createLiteral(sLastName));
			conn.add(iri, partnershipType, valFact.createLiteral(sPartnershipType));
			conn.add(iri, supplies, iSupplies);		
		}finally{
			conn.close();
		}
	}	
	
	static void createIndividualVolunteer(Repository rep, ValueFactory valFact, IRI iri, String sTshirtSize, String sFirstName, String sLastName, Date dBirthDate, IRI iWorksFor) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, volunteer);
			conn.add(iri, tshirtSize, valFact.createLiteral(sTshirtSize));
			conn.add(iri, firstName, valFact.createLiteral(sFirstName));
			conn.add(iri, lastName, valFact.createLiteral(sLastName));
			conn.add(iri, birthDate, valFact.createLiteral(dBirthDate));
			conn.add(iri, worksFor, iWorksFor);		
		}finally{
			conn.close();
		}
	}	
	
	static void createIndividualDicastery(Repository rep, ValueFactory valFact, IRI iri, String sNeedsOfMaterial, Integer nNeedsOfVolunteer, IRI iOrganize1, IRI iOrganize2) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, dicastery);
			conn.add(iri, needsOfVolunteer, valFact.createLiteral(nNeedsOfVolunteer));
			conn.add(iri, needsOfMaterial, valFact.createLiteral(sNeedsOfMaterial));
			conn.add(iri, organizes, iOrganize1);
			conn.add(iri, organizes, iOrganize2);
		}finally{
			conn.close();
		}
	}
	
	static void createIndividualPublicBar(Repository rep, ValueFactory valFact, IRI iri, String sName, Integer nCapacity, IRI iSells, IRI iIsIn) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, publicBar);
			conn.add(iri, name, valFact.createLiteral(sName));
			conn.add(iri, capacity, valFact.createLiteral(nCapacity));
			conn.add(iri, sells, iSells);
			conn.add(iri,  isIn, iIsIn);
		}finally{
			conn.close();
		}
	}
	
	static void createIndividualLimitedBar(Repository rep, ValueFactory valFact, IRI iri, String sName, Integer nCapacity, IRI iSells, IRI iIsIn) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, limitedBar);
			conn.add(iri, name, valFact.createLiteral(sName));
			conn.add(iri, capacity, valFact.createLiteral(nCapacity));
			conn.add(iri, sells, iSells);
			conn.add(iri,  isIn, iIsIn);
		}finally{
			conn.close();
		}
	}
	
	static void createIndividualPublicArea(Repository rep, ValueFactory valFact, IRI iri, String sName) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, publicArea);
			conn.add(iri, name, valFact.createLiteral(sName));
		}finally{
			conn.close();
		}
	}	
	
	static void createIndividualRestrictedArea(Repository rep, ValueFactory valFact, IRI iri, String sName, String sAccessLevel, Integer nSecuGuardNumber) {
		RepositoryConnection conn = rep.getConnection();
		try {
			conn.add(iri, RDF.TYPE, restrictedArea);
			conn.add(iri, name, valFact.createLiteral(sName));
			conn.add(iri, accessLevel, valFact.createLiteral(sAccessLevel));
			conn.add(iri, secuGuardNbr, valFact.createLiteral(nSecuGuardNumber));
		}finally{
			conn.close();
		}
	}
	
	
	
	
}
