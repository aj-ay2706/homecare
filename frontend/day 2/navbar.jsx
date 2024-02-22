import { Link } from "react-router-dom";
import "../assets/css/navbar.css";
import Img from "../assets/images/logo.png";

function NavBar() {
  return (
    <nav>
      <div><img className="navlogo" src={Img} alt="logo" /></div>
      <div className="navlinks">
        <Link className="navele" to="/">Plans</Link>
        <Link className="navele" to="/">Services</Link>
        <Link className="navele" to="/">Media</Link>
        <Link className="navele" to="/profilepage">Profile</Link>
        <Link className="navele" to="/">Logout</Link>
      </div>
    </nav>
  );
}

export default NavBar;
