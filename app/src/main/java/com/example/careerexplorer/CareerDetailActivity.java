package com.example.careerexplorer;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class CareerDetailActivity extends AppCompatActivity {

    TextView careerName, careerDescription, careerSkills, careerSalary, careerEducation, careerEnvironment, careerCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_detail);

        careerName = findViewById(R.id.careerTitle);

        careerDescription = findViewById(R.id.careerDescription);
        careerSkills = findViewById(R.id.careerSkills);
        careerSalary = findViewById(R.id.careerSalary);
        careerEducation = findViewById(R.id.careerEducation);
        careerEnvironment = findViewById(R.id.careerEnvironment);
        careerCompanies = findViewById(R.id.careerCompanies);

        String career = getIntent().getStringExtra("career");
        careerName.setText(career);

        HashMap<String, String[]> data = getCareerDetails(career);

        if (data != null) {
            careerDescription.setText("Description: " + data.get("description")[0]);
            careerSkills.setText("Skills: " + data.get("skills")[0]);
            careerSalary.setText("Salary: " + data.get("salary")[0]);
            careerEducation.setText("Education: " + data.get("education")[0]);
            careerEnvironment.setText("Work Environment: " + data.get("environment")[0]);
            careerCompanies.setText("Companies: " + data.get("companies")[0]);
        } else {
            careerDescription.setText("No details available.");
        }
    }

    private HashMap<String, String[]> getCareerDetails(String career) {
        HashMap<String, String[]> details = new HashMap<>();

        // --- ENGINEERING ---
        details.put("Software Engineer", new String[]{
                "Develops computer applications and systems software.",
                "Java, Python, Problem-solving, Algorithms, Git",
                "₹8-15 LPA",
                "B.Tech in Computer Science, MCA",
                "Office-based, Remote-friendly",
                "Google, Microsoft, Infosys, TCS"
        });

        details.put("Mechanical Engineer", new String[]{
                "Designs mechanical systems like engines, machines, and tools.",
                "AutoCAD, Mechanics, Problem-solving, CAD",
                "₹5-10 LPA",
                "B.Tech in Mechanical Engineering",
                "Factories, Plants, Research Labs",
                "Tata Motors, BHEL, L&T, Mahindra"
        });

        details.put("Civil Engineer", new String[]{
                "Plans and supervises infrastructure projects like buildings, roads, and bridges.",
                "AutoCAD, Structural Analysis, Site Supervision",
                "₹4-8 LPA",
                "B.Tech in Civil Engineering",
                "Construction sites, Government agencies",
                "L&T, Gammon India, IRCON, NBCC"
        });

        details.put("Data Scientist", new String[]{
                "Analyzes and interprets complex data to help companies make decisions.",
                "Python, SQL, Machine Learning, Statistics",
                "₹10-25 LPA",
                "B.Tech, M.Sc. in Data Science/AI",
                "IT Companies, Startups, Analytics Firms",
                "Google, Amazon, Mu Sigma, ZS Associates"
        });

        // --- MEDICAL ---
        details.put("Doctor", new String[]{
                "Treats illnesses and injuries, and prescribes medications.",
                "Medical Knowledge, Communication, Empathy",
                "₹10-25 LPA",
                "MBBS, MD",
                "Hospitals, Clinics, Research Labs",
                "Apollo, Fortis, AIIMS, Manipal"
        });

        details.put("Dentist", new String[]{
                "Specializes in oral health and dental care.",
                "Precision, Communication, Dental Tools",
                "₹6-15 LPA",
                "BDS, MDS",
                "Dental Clinics, Hospitals",
                "Clove Dental, Apollo Dental, Private Clinics"
        });

        details.put("Pharmacist", new String[]{
                "Dispenses medication and advises on drug use.",
                "Pharmacology, Detail-oriented, Customer Interaction",
                "₹3-8 LPA",
                "B.Pharm, M.Pharm",
                "Hospitals, Medical Stores",
                "Apollo Pharmacy, MedPlus, Government Hospitals"
        });

        details.put("Nurse", new String[]{
                "Cares for patients and assists doctors during treatment.",
                "Compassion, Medical Knowledge, Patience",
                "₹2.5-6 LPA",
                "B.Sc. Nursing, GNM",
                "Hospitals, Clinics, Home Care",
                "AIIMS, Fortis, Max Healthcare"
        });

        // --- ARTS ---
        details.put("Graphic Designer", new String[]{
                "Creates visual content for marketing, websites, and products.",
                "Creativity, Adobe Photoshop, Illustrator, Typography",
                "₹3-8 LPA",
                "Bachelor in Fine Arts, Design courses",
                "Agencies, Startups, Freelance",
                "Fiverr, Upwork, Ogilvy, Wipro Digital"
        });

        details.put("Animator", new String[]{
                "Creates animations for films, games, and ads.",
                "Animation software, Creativity, Storyboarding",
                "₹4-10 LPA",
                "BFA, Animation Courses",
                "Studios, Media Companies",
                "Disney, Nickelodeon, Red Chillies VFX"
        });

        details.put("Writer", new String[]{
                "Writes content for blogs, books, scripts, etc.",
                "Language skills, Creativity, Research",
                "₹2-8 LPA",
                "BA in English, Journalism",
                "Publishing Houses, Freelance",
                "Times Group, Penguin, Medium, NDTV"
        });

        details.put("Photographer", new String[]{
                "Captures images for various purposes (wedding, wildlife, editorial).",
                "Photography, Editing, Creativity",
                "₹3-8 LPA",
                "Diploma in Photography or Self-taught",
                "Studios, Media, Freelance",
                "NatGeo, WeddingWire, Agencies"
        });

        // --- COMMERCE ---
        details.put("Accountant", new String[]{
                "Manages financial records, taxes, audits.",
                "Excel, Tally, Financial Analysis",
                "₹4-10 LPA",
                "B.Com, CA",
                "Corporate Firms, Banks",
                "Deloitte, PwC, EY, KPMG"
        });

        details.put("Business Analyst", new String[]{
                "Analyzes business data to improve operations.",
                "Excel, Data Analysis, Communication, SQL",
                "₹6-12 LPA",
                "BBA, MBA, BA Certification",
                "IT, Finance, Consulting",
                "Accenture, ZS, Capgemini"
        });

        details.put("Economist", new String[]{
                "Studies market trends and economic data.",
                "Maths, Statistics, Research, Report Writing",
                "₹8-15 LPA",
                "BA/MA in Economics",
                "Government, Research Firms, Banks",
                "NITI Aayog, RBI, IMF, World Bank"
        });

        details.put("Stock Broker", new String[]{
                "Buys and sells stocks on behalf of clients.",
                "Finance, Risk Analysis, Quick Decision Making",
                "₹5-20 LPA",
                "B.Com, NISM Certification",
                "Stock Exchanges, Broker Firms",
                "Zerodha, Groww, ICICI Direct, HDFC Securities"
        });

        return details.containsKey(career) ? createMap(details.get(career)) : null;
    }


    private HashMap<String, String[]> createMap(String[] data) {
        HashMap<String, String[]> map = new HashMap<>();
        map.put("description", new String[]{data[0]});
        map.put("skills", new String[]{data[1]});
        map.put("salary", new String[]{data[2]});
        map.put("education", new String[]{data[3]});
        map.put("environment", new String[]{data[4]});
        map.put("companies", new String[]{data[5]});
        return map;
    }
}
