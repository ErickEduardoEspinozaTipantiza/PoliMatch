import mongoose from "mongoose";
import bcrypt from "bcryptjs";
import User from "../models/User.js";
import dotenv from "dotenv";

dotenv.config();

const maleNames = ["Diego", "Carlos", "Miguel", "Andrés", "Luis", "Jorge", "Daniel", "Gabriel", "Eduardo"];

const femaleNames = [
	"Ana",
    "María",
    "Valeria",
    "Sofía",
    "Daniela",
    "Laura",
    "Isabella",
    "Carolina",
    "Camila",
    "Victoria",
    "Paula",
    "Andrea",
];

const genderPreferences = ["male", "female", "both"];

const bioDescriptors = [
	"Apasionado por el desarrollo web y experto en JavaScript",
    "Amante del café y del código limpio, React developer",
    "Full-stack developer | Gamer en mis tiempos libres",
    "Backend developer, fascinado por la arquitectura de software",
    "Machine Learning enthusiast | Python lover",
    "Frontend developer | UX/UI design | Coffee addict",
    "DevOps en proceso | Amante de Docker y la automatización",
    "Mobile developer | Flutter & React Native | Tecnología móvil",
    "Data Science passionate | Pythonista | IA explorer",
    "Cloud computing enthusiast | AWS certified",
    "Cybersecurity learner | Ethical hacking passionate",
    "MERN stack developer | Open source contributor",
    "Angular developer | TypeScript fan | Clean code practitioner",
    "Java backend developer | Spring Boot expert",
    "Node.js backend | MongoDB master | API designer",
    "Vue.js frontend | UI/UX enthusiast | CSS artist",
    "QA automation | Testing passionate | Bug hunter",
    "Blockchain explorer | Smart contracts developer",
    "Linux user | Open source contributor | Git master",
    "Scrum enthusiast | Agile methodologies practitioner",
];

const generateBio = () => {
	const descriptors = bioDescriptors.sort(() => 0.5 - Math.random()).slice(0, 3);
	return descriptors.join(" | ");
};

const generateRandomUser = (gender, index) => {
	const names = gender === "male" ? maleNames : femaleNames;
	const name = names[index];
	const age = Math.floor(Math.random() * (45 - 21 + 1) + 21);
	return {
		name,
		email: `${name.toLowerCase()}${age}@example.com`,
		password: bcrypt.hashSync("password123", 10),
		age,
		gender,
		genderPreference: genderPreferences[Math.floor(Math.random() * genderPreferences.length)],
		bio: generateBio(),
		image: `/${gender}/${index + 1}.jpg`,
	};
};

const seedUsers = async () => {
	try {
		await mongoose.connect(process.env.MONGO_URI);

		await User.deleteMany({});

		const maleUsers = maleNames.map((_, i) => generateRandomUser("male", i));
		const femaleUsers = femaleNames.map((_, i) => generateRandomUser("female", i));

		const allUsers = [...maleUsers, ...femaleUsers];

		await User.insertMany(allUsers);

		console.log("Database seeded successfully with users having concise bios");
	} catch (error) {
		console.error("Error seeding database:", error);
	} finally {
		mongoose.disconnect();
	}
};

seedUsers();