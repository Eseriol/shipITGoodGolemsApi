package ship.it.goodgolems.core.providers;

import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

/**
 * The Provider class is a subclass of AbstractProvider and provides methods to generate random data related to technology stacks, professions, and project names.
 *
 * @param <BaseProviders> the type of the base provider used by the Provider class
 */
public class Provider extends AbstractProvider<BaseProviders> {

    private static final String[] STACKS_TECHNOLOGY_NAMES = new String[]{ "Java", "Python", "JavaScript", "C#", "C++", "Ruby", "Go", "Swift", "Kotlin", "PHP", "HTML", "CSS", "SQL", "TypeScript", "R", "MATLAB", "Scala", "Rust", "Dart", "Objective-C", "Visual Basic", "Shell Scripting", "Bash", "PowerShell", "XML", "JSON", "YAML", "Docker", "Kubernetes", "Jenkins", "Travis CI", "CircleCI", "Git", "SVN", "Mercurial", "AWS", "Azure", "Google Cloud Platform", "Heroku", "Firebase", "Oracle Cloud", "IBM Cloud", "Apache", "Nginx", "IIS", "PostgreSQL", "MySQL", "SQLite", "MongoDB", "Redis", "Cassandra", "Elasticsearch", "Solr", "RabbitMQ", "Kafka", "ActiveMQ", "GraphQL", "REST", "SOAP", "gRPC", "WebSockets", "React", "Angular", "Vue.js", "Svelte", "Backbone.js", "Ember.js", "Node.js", "Express.js", "Django", "Flask", "Spring Boot", "Hibernate", "Rails", "Laravel", "Symfony", "ASP.NET", "Meteor", "TensorFlow", "PyTorch", "Keras", "Scikit-learn", "Pandas", "NumPy", "SciPy", "Hadoop", "Spark", "Flink", "Hive", "Pig", "Presto", "Airflow", "Tableau", "Power BI", "QlikView", "Looker", "MicroStrategy", "Splunk", "New Relic", "Dynatrace", "Prometheus", "Grafana", "Selenium", "Cucumber", "JUnit", "TestNG", "Mockito", "Jest", "Mocha", "Chai", "Jasmine", "Cypress", "Puppeteer", "Protractor", "Appium", "Robot Framework", "Gatling", "JMeter", "LoadRunner", "Ansible", "Chef", "Puppet", "SaltStack", "Terraform", "Vagrant", "CloudFormation", "Packer" };

    private static final String[] PROFESSIONS_NAMES = new String[]{ "Software Developer", "Software Engineer", "Front-End Developer", "Back-End Developer", "Full-Stack Developer", "DevOps Engineer", "Systems Administrator", "Database Administrator (DBA)", "Network Engineer", "Cloud Engineer", "Data Scientist", "Data Analyst", "Data Engineer", "Machine Learning Engineer", "AI Engineer", "Security Analyst", "Security Engineer", "Penetration Tester", "Project Manager", "Product Manager", "Scrum Master", "Business Analyst", "QA Engineer", "QA Tester", "UI/UX Designer", "UI/UX Developer", "Technical Support Engineer", "Help Desk Technician", "IT Support Specialist", "IT Manager", "Solutions Architect", "Enterprise Architect", "Application Architect", "Mobile Developer", "Game Developer", "Embedded Systems Engineer", "Firmware Engineer", "Hardware Engineer", "IT Consultant", "Systems Analyst", "Release Manager", "Configuration Manager", "IT Operations Manager", "Technical Writer", "IT Trainer", "Compliance Manager", "IT Auditor", "Site Reliability Engineer (SRE)", "Build Engineer", "IT Procurement Specialist" };

    private static final String[] PROJECT_NAMES = new String[]{ "CyberGuard: Sentinel of Security", "DataMingle: Fusion of Insights", "CodeCrafter: Crafting Digital Solutions", "CloudByte: Navigating the Cloud", "AI Nexus: Where Intelligence Meets Innovation", "NetForge: Building Connections", "VirtualVerse: Exploring the Virtual Realm", "TechTonic: Powering Digital Transformation", "PixelPulse: Vibrant Visual Solutions", "BitBlaze: Igniting Digital Progress", "InfoMatrix: Shaping Data Landscapes", "CryptoSphere: Securing Digital Transactions", "AgileWave: Riding the Tide of Innovation", "CyberSculpt: Carving Secure Networks", "DataSphere: Mapping Information Realms", "CodeNova: Stars of Software Development", "CloudCraze: Storming the Digital Sky", "AI Symphony: Orchestrating Intelligent Solutions", "NetVoyage: Navigating Digital Waters", "VirtualVista: Exploring Virtual Horizons", "TechTrek: Journeying through Technology", "PixelForge: Forging Digital Experiences", "BitBurst: Bursting with Digital Innovation", "InfoGenius: Crafting Insights from Data", "CryptoForge: Fortifying Digital Assets", "AgileCore: Core of Digital Agility", "CyberPulse: Pulsating with Cybersecurity", "DataDrift: Navigating Data Currents", "CodeSprint: Accelerating Software Development", "CloudClan: United in the Cloud", "AI Avenue: Pathway to Intelligent Solutions", "NetNova: Discovering Digital Frontiers", "VirtualVortex: Whirlwind of Virtual Innovation", "TechTrail: Blaze your Digital Trail", "PixelPioneer: Leading the Digital Frontier", "BitBlast: Explosive Digital Solutions", "InfoSphere: Orb of Data Insights", "CryptoGuard: Guardian of Digital Assets", "AgileBeam: Beam of Digital Agility", "CyberCraft: Crafting Secure Networks", "DataQuest: Journey into Data Realms", "CodeCraft: Crafting Code Masterpieces", "CloudComet: Soaring through Digital Skies", "AI Apex: Peak of Intelligent Solutions", "NetNest: Building Digital Habitats", "VirtualVision: Visionary Virtual Solutions", "TechTide: Riding the Digital Wave", "PixelPulse: Pulse of Digital Creativity", "BitBolt: Bolting into the Digital Future", "InfoPulse: Pulse of Data Insights" };

    /**
     * The Provider class provides additional functionality to the BaseProviders class.
     * It extends the AbstractProvider class and is used to generate various types of data.
     */
    public Provider(BaseProviders faker) {
        super(faker);
    }

    /**
     * Returns a random technology name from the STACKS_TECHNOLOGY_NAMES array.
     *
     * @return A random technology name.
     */
    public String stack() {
        return STACKS_TECHNOLOGY_NAMES[faker.random().nextInt(STACKS_TECHNOLOGY_NAMES.length)];
    }

    /**
     * Generates a random profession name.
     *
     * @return A randomly generated profession name.
     */
    public String profession() {
        return PROFESSIONS_NAMES[faker.random().nextInt(PROFESSIONS_NAMES.length)];
    }

    /**
     * Generates a random project name.
     *
     * @return A randomly selected project name from the list of available project names.
     */
    public String project() {
        return PROJECT_NAMES[faker.random().nextInt(PROJECT_NAMES.length)];
    }
}

