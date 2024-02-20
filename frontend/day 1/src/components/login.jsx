import  { useState } from 'react';
import '../assets/login.css';

const Login = () => {
  const [isSignUp, setIsSignUp] = useState(false);

  const switchForm = () => {
    setIsSignUp((prevIsSignUp) => !prevIsSignUp);
  };

  return (
    <>
      <meta charSet="UTF-8" />
      <meta httpEquiv="X-UA-Compatible" content="IE=edge" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>meta.codes - Animated Login and Registration Form</title>
      <link rel="stylesheet" href="style.css" />

      <div className={`wrapper ${isSignUp ? 'animate-signUp' : 'animate-signIn'}`}>

        <div className="form-wrapper sign-up">
          <form action="">
            <h2>Sign Up</h2>
            <div className="input-group">
              <input type="text" placeholder="Name" required />
              <label htmlFor="">Name</label>
            </div>
            <div className="input-group">
              <input type="email" placeholder="Email" required />
              <label htmlFor="">Email</label>
            </div>
            <div className="input-group">
              <input type="password" placeholder="Password" required />
              <label htmlFor="">Password</label>
            </div>
            <button type="submit" className="btn">
              Sign Up
            </button>
            <div className="sign-link">
              <p>
                Already have an account?{' '}
                <button type="button" className="signIn-link" onClick={switchForm}>
                  Sign In
                </button>
              </p>
            </div>
          </form>
        </div>

        <div className="form-wrapper sign-in">
          <form action="">
            <h2>Login</h2>
            <div className="input-group">
              <input type="email" placeholder="Email" required />
              <label htmlFor="">Email</label>
            </div>
            <div className="input-group">
  <input type="password" placeholder="Password" required />
  <label htmlFor="">Password</label>
</div>

            <div className="forgot-pass">
              <a href="#">Forgot Password?</a>
            </div>
            <button type="submit" className="btn" >
              Login
            </button>
            <div className="sign-link">
  <p>
    Dont have an account?{' '}
    <button type="button" className="signUp-link" onClick={switchForm}>
      Sign Up
    </button>
  </p>
</div>

          </form>
        </div>
      </div>
    </>
  );
};

export default Login;