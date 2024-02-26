// import { Link } from "react-router-dom";
import { Link } from 'react-router-dom';
import '../assets/css/role.css';
import RoleBcg from "../assets/images/rolebg.jpg";
function RolePage() {
  

  return (
    <>
    <div className='role-container' style={{backgroundImage:`url(${RoleBcg})`,backgroundSize:"cover",height:"100vh",width:"100vw"}}>

  <div className='rolebody' style={{paddingTop:"10%"}}>
  <div className="rolecard">ADMIN 
  <Link to="/login">
   LOGIN
   </Link>
  </div>
  <br></br>
  <div className="rolecard">USER 
  <Link to="/login">
    LOGIN
   </Link>
   </div>
  </div>
    </div>
</>
  );
}

export default RolePage;
