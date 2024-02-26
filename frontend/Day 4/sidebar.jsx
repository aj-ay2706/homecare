import { Link } from "react-router-dom";
import "../assets/css/sidebar.css"; // Update the CSS file import
import Img from "../assets/images/logo.png";

function Sidebar() {
  return (
    <div className="sidebar">
      <img className="sidebar-logo" src={Img} alt="logo" />
      <div className="sidebar-links">
        <Link className="sidebar-link" to="/adminhomepage">Home</Link>
        <Link className="sidebar-link" to="/adminservice">Services</Link>
        <Link className="sidebar-link" to="/feedback">Feedback</Link>
        <Link className="sidebar-link" to="/adminprofilepage">Profile</Link>
        <Link className="sidebar-link" to="/">Logout</Link>
      </div>
    </div>
  );
}

export default Sidebar;
