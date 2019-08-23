package com.example.demo.data;

import com.example.demo.data.anemics.document.DocumentCategoryAnemic;
import com.example.demo.data.anemics.document.DocumentTypeAnemic;
import com.example.demo.data.anemics.document.DocumentTypeRulesetAnemic;
import com.example.demo.data.repositories.services.DocumentCategoryRepositoryService;
import com.example.demo.data.repositories.services.DocumentTypeRepositoryService;
import com.example.demo.data.repositories.services.DocumentTypeRulesetRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Seeder implements ApplicationListener<ContextRefreshedEvent> {
    private DocumentTypeRepositoryService documentTypeRepositoryService;
    private DocumentCategoryRepositoryService documentCategoryRepositoryService;
    private DocumentTypeRulesetRepositoryService documentTypeRulesetRepositoryService;

    private List<DocumentCategoryAnemic> documentCategoriesList;
    private List<DocumentTypeAnemic> documentTypesList;

    @Autowired
    public Seeder(
            DocumentTypeRepositoryService documentTypeRepositoryService,
            DocumentCategoryRepositoryService documentCategoryRepositoryService,
            DocumentTypeRulesetRepositoryService documentTypeRulesetRepositoryService) {
        this.documentTypeRepositoryService = documentTypeRepositoryService;
        this.documentCategoryRepositoryService = documentCategoryRepositoryService;
        this.documentTypeRulesetRepositoryService = documentTypeRulesetRepositoryService;
    }

    private void createDocumentCategories() {
        var documentCategories = this.documentCategoryRepositoryService.getDocumentCategories();
        if (documentCategories == null || documentCategories.isEmpty()) {
            documentCategoriesList = new ArrayList<>();
            documentCategoriesList.add(DocumentCategoryAnemic.createEntity("Vehicles", "View and manage your vehicle licence discs and insurance policies"));
            documentCategoriesList.add(DocumentCategoryAnemic.createEntity("Personal", "View and manage your South African National ID document, passport and driver's licence"));
            documentCategoriesList.add(DocumentCategoryAnemic.createEntity("Education", "View and manage your secondary certificates and tertiary certificates"));
            documentCategoriesList.add(DocumentCategoryAnemic.createEntity("Home", "View and manage your lease agreements and municipal bills"));
            documentCategoriesList.add(DocumentCategoryAnemic.createEntity("Finances", "View and manage your bank statements and proof of income"));
            documentCategoriesList.add(DocumentCategoryAnemic.createEntity("Life", "View and manage your last will and testament and funeral policies"));

            this.documentCategoryRepositoryService.saveChanges(documentCategoriesList);
        }
    }

    private void createDocumentTypes() {
        var documentTypes = this.documentTypeRepositoryService.getDocumentTypes();
        if (documentTypes == null || documentTypes.isEmpty()) {
            var vehiclesCategory = this.documentCategoriesList.get(0);
            var personalCategory = this.documentCategoriesList.get(1);
            var educationCategory = this.documentCategoriesList.get(2);
            var homeCategory = this.documentCategoriesList.get(3);
            var financesCategory = this.documentCategoriesList.get(4);
            var lifeCategory = this.documentCategoriesList.get(5);

            documentTypesList = new ArrayList<>();
            // vehicles
            documentTypesList.add(DocumentTypeAnemic.createEntity(vehiclesCategory, "Vehicle Insurance Policy", "Outsurance", false, true, 13));
            documentTypesList.add(DocumentTypeAnemic.createEntity(vehiclesCategory, "Vehicle Licence Disc", "CarLicenceDisc", false, true, 12));
            documentTypesList.add(DocumentTypeAnemic.createEntity(vehiclesCategory, "Proof Of Ownership", "Natis", false, true, 11));
            // personal
            documentTypesList.add(DocumentTypeAnemic.createEntity(personalCategory, "Curriculumn Vitae", "Curriculum Vitae", true, false, 23));
            documentTypesList.add(DocumentTypeAnemic.createEntity(personalCategory, "National ID Card", "South African Identity Card", true, false, 2));
            documentTypesList.add(DocumentTypeAnemic.createEntity(personalCategory, "Driver's Licence", "South African Drivers Licence", true, false, 7));
            documentTypesList.add(DocumentTypeAnemic.createEntity(personalCategory, "Passport", "South African Passport", true, false, 8));
            documentTypesList.add(DocumentTypeAnemic.createEntity(personalCategory, "National ID Book", "South African Identity Document", true, false, 1));
            // education
            documentTypesList.add(DocumentTypeAnemic.createEntity(educationCategory, "Secondary Certificate", "Secondary Certificate", false, true, 14));
            documentTypesList.add(DocumentTypeAnemic.createEntity(educationCategory, "Tertiary Certificate", "Tertiary Certificate", false, true, 17));
            // home
            documentTypesList.add(DocumentTypeAnemic.createEntity(homeCategory, "Household Content Insurance Policy", "Household Content Insurance Policy", false, true, 24));
            documentTypesList.add(DocumentTypeAnemic.createEntity(homeCategory, "Municipal Bill", "Water & Electricity Bill", false, true, 4));
            documentTypesList.add(DocumentTypeAnemic.createEntity(homeCategory, "Proof Of Residence", "Proof For Physical Address", false, true, 3));
            documentTypesList.add(DocumentTypeAnemic.createEntity(homeCategory, "Lease Agreement", "Lease Agreement For Rental Properties", false, true, 5));
            documentTypesList.add(DocumentTypeAnemic.createEntity(homeCategory, "Deed Of Ownership", "Deed Of Ownership", false, true, 6));
            documentTypesList.add(DocumentTypeAnemic.createEntity(homeCategory, "Home Insurance Policy", "Home Insurance Policy", false, true, 22));
            // finances
            documentTypesList.add(DocumentTypeAnemic.createEntity(financesCategory, "Tax Certificate", "Tax Certificate", false, true, 18));
            documentTypesList.add(DocumentTypeAnemic.createEntity(financesCategory, "Investment Contract", "Investment Contract", false, true, 19));
            documentTypesList.add(DocumentTypeAnemic.createEntity(financesCategory, "Bank Statement", "Bank Statement", false, true, 10));
            documentTypesList.add(DocumentTypeAnemic.createEntity(financesCategory, "Proof Of Income", "Proof Of Income", false, true, 9));
            // life
            documentTypesList.add(DocumentTypeAnemic.createEntity(lifeCategory, "Life Insurance Policy", "Life Insurance", false, true, 15));
            documentTypesList.add(DocumentTypeAnemic.createEntity(lifeCategory, "Medical Aid Card", "Discovery", false, true, 21));
            documentTypesList.add(DocumentTypeAnemic.createEntity(lifeCategory, "Last Will And Testament", "Last Will And Testament", false, true, 20));
            documentTypesList.add(DocumentTypeAnemic.createEntity(lifeCategory, "Funeral Policy", "Funeral Policy", false, true, 16));

            this.documentTypeRepositoryService.saveChanges(documentTypesList);
        }
    }

    private void createDocumentTypeRulesets() {
        var documentTypeRulesets = this.documentTypeRulesetRepositoryService.getDocumentTypeRulesets();
        if (documentTypeRulesets == null || documentTypeRulesets.isEmpty()) {
            var vehicleInsurancePolicy = this.documentTypesList.get(0);
            var vehicleLicenceDisc = this.documentTypesList.get(1);
            var proofOfOwnership = this.documentTypesList.get(2);
            var curriculumnVitae = this.documentTypesList.get(3);
            var nationalIdCard = this.documentTypesList.get(4);
            var driversLicence = this.documentTypesList.get(5);
            var passport = this.documentTypesList.get(6);
            var nationalIdBook = this.documentTypesList.get(7);
            var secondaryCertificate = this.documentTypesList.get(8);
            var tertiaryCertificate = this.documentTypesList.get(9);
            var householdContentInsrancePolicy = this.documentTypesList.get(10);
            var municipalBill = this.documentTypesList.get(11);
            var proofOfResidence = this.documentTypesList.get(12);
            var leaseAgreement = this.documentTypesList.get(13);
            var deedOfOwnership = this.documentTypesList.get(14);
            var homeInsurancePolicy = this.documentTypesList.get(15);
            var taxCertificate = this.documentTypesList.get(16);
            var investmentContract = this.documentTypesList.get(17);
            var bankStatement = this.documentTypesList.get(18);
            var proofOfIncome = this.documentTypesList.get(19);
            var lifeInsurancePolicy = this.documentTypesList.get(20);
            var medicalAidCard = this.documentTypesList.get(21);
            var lastWillAndTestament = this.documentTypesList.get(22);
            var funeralPolicy = this.documentTypesList.get(23);

            var rulesetsList = new ArrayList<DocumentTypeRulesetAnemic>();
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(bankStatement, "Bank Statement JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(bankStatement, "Bank Statement PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(curriculumnVitae, "Curriculum Vitae JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(curriculumnVitae, "Curriculum Vitae PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(deedOfOwnership, "Deed Of Ownership JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(deedOfOwnership, "Deed Of Ownership PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(driversLicence, "Drivers Licence Rule Set", 2, 2, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(funeralPolicy, "Funeral Policy JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(funeralPolicy, "Funeral Policy PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(homeInsurancePolicy, "Home Insurance Policy JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(homeInsurancePolicy, "Home Insurance Policy PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(householdContentInsrancePolicy, "Household Content Insurance Policy JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(householdContentInsrancePolicy, "Household Content Insurance Policy PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(nationalIdBook, "Identity Book Rule Set", 1, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(nationalIdCard, "Identity Card Rule Set", 2, 2, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(investmentContract, "Investment Contract JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(investmentContract, "Investment Contract PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(lastWillAndTestament, "Last Will And Testament JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(lastWillAndTestament, "Last Will And Testament PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(leaseAgreement, "Lease Agreement JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(leaseAgreement, "Lease Agreement PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(lifeInsurancePolicy, "Life Insurance JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(lifeInsurancePolicy, "Life Insurance PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(medicalAidCard, "Medical Aid Card JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(medicalAidCard, "Medical Aid Card PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(municipalBill, "Municipal Bill JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(municipalBill, "Municipal Bill PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(passport, "Passport Rule Set", 1, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(proofOfIncome, "Proof Of Income JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(proofOfIncome, "Proof Of Income PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(proofOfResidence, "Proof Of Residence JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(proofOfResidence, "Proof Of Residence PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(proofOfOwnership, "Proof Of Ownership Rule Set", 1, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(secondaryCertificate, "Secondary Education Certificate JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(secondaryCertificate, "Secondary Education Certificate PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(taxCertificate, "Tax Certificate JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(taxCertificate, "Tax Certificate PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(tertiaryCertificate, "Tertiary Education Certificate JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(tertiaryCertificate, "Tertiary Education Certificate PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(vehicleInsurancePolicy, "Vehicle Insurance Policy JPG Rule Set", 50, 1, "jpg"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(vehicleInsurancePolicy, "Vehicle Insurance Policy PDF Rule Set", 1, 1, "pdf"));
            rulesetsList.add(DocumentTypeRulesetAnemic.createEntity(vehicleLicenceDisc, "Vehicle Licence Disc JPG Rule Set", 1, 1, "jpg"));

            this.documentTypeRulesetRepositoryService.saveChanges(rulesetsList);
        }

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.createDocumentCategories();
        this.createDocumentTypes();
        this.createDocumentTypeRulesets();
    }
}
