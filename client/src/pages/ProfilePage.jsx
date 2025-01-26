import { useRef, useState } from "react";
import { Header } from "../components/Header";
import { useAuthStore } from "../store/useAuthStore";
import { useUserStore } from "../store/useUserStore";


const ProfilePage = () => {
  
  const { authUser } = useAuthStore();
  const [name, setName] = useState(authUser.name || "");
  const [bio, setBio] = useState(authUser.bio || "");
  const [age, setAge] = useState(authUser.age || "");
  const [gender, setGender] = useState(authUser.gender || "");
  const [genderPreference, setGenderPreference] = useState(authUser.genderPreference || []);
  const [image, setImage] = useState(authUser.image || null);

  
  const fileInputRef = useRef();

  const {loading, updateProfile} = useUserStore();

  const handleSubmit = (e) => {
    e.preventDefault();
    updateProfile({ name, bio, age, gender, genderPreference, image });
  };
  const handleImageChange = (e) => {
		const file = e.target.files[0];
		if (file) {
			const reader = new FileReader();
			reader.onloadend = () => {
				setImage(reader.result);
			};

			reader.readAsDataURL(file);
		}
	};

	console.log(image);
  
    return (
		<div className="min-h-screen bg-gray-50">
		  <Header />
	
		  {/* Main Content */}
		  <div className="max-w-7xl mx-auto px-4 py-8">
			<div className="text-2xl font-semibold mb-4">Settings</div>
			
			<div className="flex gap-8">
			  {/* Left Column - Profile Image */}
			  <div className="w-1/3">
				<div className="text-xl mb-4">Profile</div>
				<div className="flex flex-col items-center">
				  <div className="w-48 h-48 rounded-full overflow-hidden mb-4 border-4 border-white shadow-lg">
					{image ? (
					  <img src={image} alt="Profile" className="w-full h-full object-cover" />
					) : (
					  <div className="w-full h-full bg-gray-200" />
					)}
				  </div>
				  <button
					type="button"
					onClick={() => fileInputRef.current.click()}
					className="w-full mb-2 bg-rose-500 text-white py-2 px-4 rounded-md hover:bg-rose-600 transition-colors"
				  >
					Upload new avatar
				  </button>
				  <input
					ref={fileInputRef}
					type="file"
					accept="image/*"
					className="hidden"
					onChange={handleImageChange}
				  />
				</div>
			  </div>
	
			  {/* Right Column - Form */}
			  <div className="w-2/3">
				<div className="bg-white rounded-lg shadow p-6">
				  <div className="text-xl mb-6">Basic Info</div>
				  <form onSubmit={handleSubmit} className="space-y-6">
					<div className="grid grid-cols-2 gap-6">
					  <div>
						<label className="block text-sm font-medium text-gray-700 mb-1">Name</label>
						<input
						  type="text"
						  value={name}
						  onChange={(e) => setName(e.target.value)}
						  required
						  className="w-full px-3 py-2 border border-gray-300 rounded-md focus:ring-rose-500 focus:border-rose-500"
						/>
					  </div>
					  <div>
						<label className="block text-sm font-medium text-gray-700 mb-1">Age</label>
						<input
						  type="number"
						  value={age}
						  onChange={(e) => setAge(e.target.value)}
						  required
						  className="w-full px-3 py-2 border border-gray-300 rounded-md focus:ring-rose-500 focus:border-rose-500"
						/>
					  </div>
					</div>
	
					<div className="space-y-4">
					  <div>
						<label className="block text-sm font-medium text-gray-700 mb-2">Gender</label>
						<div className="flex space-x-4">
						  {["Male", "Female"].map((option) => (
							<label key={option} className="inline-flex items-center">
							  <input
								type="radio"
								className="form-radio text-rose-500"
								name="gender"
								value={option.toLowerCase()}
								checked={gender === option.toLowerCase()}
								onChange={() => setGender(option.toLowerCase())}
							  />
							  <span className="ml-2">{option}</span>
							</label>
						  ))}
						</div>
					  </div>
	
					  <div>
						<label className="block text-sm font-medium text-gray-700 mb-2">Gender Preference</label>
						<div className="flex space-x-4">
						  {["Male", "Female", "Both"].map((option) => (
							<label key={option} className="inline-flex items-center">
							  <input
								type="checkbox"
								className="form-checkbox text-rose-500"
								checked={Array.isArray(genderPreference) 
								  ? genderPreference.includes(option.toLowerCase())
								  : genderPreference === option.toLowerCase()}
								onChange={() => setGenderPreference(option.toLowerCase())}
							  />
							  <span className="ml-2">{option}</span>
							</label>
						  ))}
						</div>
					  </div>
					</div>
	
					<div>
					  <label className="block text-sm font-medium text-gray-700 mb-1">Bio</label>
					  <textarea
						value={bio}
						onChange={(e) => setBio(e.target.value)}
						rows={4}
						className="w-full px-3 py-2 border border-gray-300 rounded-md focus:ring-rose-500 focus:border-rose-500"
					  />
					</div>
	
					<div className="flex justify-end space-x-4">
					  <button
						type="button"
						className="px-4 py-2 border border-gray-300 rounded-md hover:bg-gray-50"
					  >
						Cancel
					  </button>
					  <button
						type="submit"
						disabled={loading}
						className="px-4 py-2 bg-rose-500 text-white rounded-md hover:bg-rose-600 disabled:opacity-50"
					  >
						{loading ? "Saving..." : "Save"}
					  </button>
					</div>
				  </form>
				</div>
			  </div>
			</div>
		  </div>
		</div>
	);    
    
};

export default ProfilePage;
