import { axiosInstance } from "../lib/axios";
import toast from "react-hot-toast";
import { create } from "zustand";

export const useUserStore = create((set) => ({

    loading : false,
    
    updateProfile: async (data) => {
        try {   
            set({loading: true});
            await axiosInstance.put("users/update", data);
            toast.success("Profile updated successfully");
        } catch (error) {
            toast.error(error.response.data.message ||"An error occurred in /useUserStore.js" );
        } finally {
            set({loading: false});
        }
    }

}))