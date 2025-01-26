import { useState } from "react";

import LoginForm from "../components/LoginForm";
import SignUpForm from "../components/SignUpForm";

import flameIcon from "../assets/Logo.png";
import loginBackground from "../assets/tinder1.png";
import signupBackground from "../assets/blanco.png";
import overlayImageRight from "../assets/overlay-right.png";
import overlayImageLeft from "../assets/overlay-left.png"; 

const AuthPage = () => {
	const [isLogin, setIsLogin] = useState(true);

	return (
		<div
      className={`min-h-screen flex items-center justify-center bg-cover p-4 relative overflow-hidden transition-all duration-500`}
      style={{
        backgroundImage: `url(${isLogin ? loginBackground : signupBackground})`,
      }}
    >
      {/* Icono y Título */}
      <div className="absolute top-6 left-6 flex items-center space-x-4">
        <img src={flameIcon} alt="PoliMatch Icon" className="w-12 h-12" />
        <h1 className="text-white font-bold text-3xl lg:text-4xl">POLIMATCH</h1>
      </div>

      {/* Contenedor central con animación de transición */}
      <div
        className={`w-full max-w-md bg-white shadow-x0 rounded-lg p-8 relative z-10 transition-transform duration-500`}
        style={{
          transform: isLogin ? "translateX(-50%)" : "translateX(100%)",
        }}
      >
        <h2 className="text-center text-3xl font-extrabold text-gray-800 mb-8">
          {isLogin ? "Empieza ahora 🔥" : "Create an Account Free"}
        </h2>

        {/* Formularios */}
        {isLogin ? <LoginForm /> : <SignUpForm />}

        <div className="mt-8 text-center">
          <p className="text-sm text-gray-600">
            {isLogin ? "¿Nuevo en PoliMatch?" : "¿Ya tienes una cuenta?"}
          </p>

          <button
            onClick={() => setIsLogin((prevIsLogin) => !prevIsLogin)}
            className="mt-2 text-red-600 hover:text-red-800 font-medium transition-colors duration-300"
            aria-label={isLogin ? "Switch to sign up form" : "Switch to login form"}
          >
            {isLogin ? "Crea una nueva cuenta" : "Inicia sesión"}
          </button>
        </div>
      </div>

      {/* Overlay a la derecha */}
      <div
        className={`absolute top-0 right-0 h-full w-2/8 pointer-events-none transition-opacity duration-500 ${
          isLogin ? "opacity-100" : "opacity-0"
        }`}
      >
        <img
          src={overlayImageRight}
          alt="Overlay Right"
          className="h-full w-full object-cover"
        />
      </div>

      {/* Overlay a la izquierda */}
      <div
        className={`absolute top-0 left-0 h-full w-3/5 pointer-events-none transition-opacity duration-500 ${
          isLogin ? "opacity-0" : "opacity-100"
        }`}
      >
        <img
          src={overlayImageLeft}
          alt="Overlay Left"
          className="h-full w-full object-cover"
        />
      </div>
    </div>
	);
};
export default AuthPage;