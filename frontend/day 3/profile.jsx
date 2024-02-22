import { useState } from 'react';
import '../assets/css/profile.css';
import Img from "../assets/images/profile2.jpg";
function ProfilePage() {
  
  const [userData, setUserData] = useState({
    firstName: 'John',
    email: 'johndoe@example.com',
    gender:'male',
    age:32
  });

  const [profileImage, setProfileImage] = useState(Img);
  
  const [isEditMode, setIsEditMode] = useState(false);
  const [editedData, setEditedData] = useState({ ...userData });
  const [editedImage, setEditedImage] = useState('');

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditedData({ ...editedData, [name]: value });
  };

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    const reader = new FileReader();
    reader.onloadend = () => {
      setEditedImage(reader.result);
    };
    if (file) {
      reader.readAsDataURL(file);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setUserData({ ...editedData });
    if (editedImage) {
      setProfileImage(editedImage);
    }
    setIsEditMode(false);
  };

  return (
    <>
      <div className='whole'>
        <div>
          <img className="profilepic" src={profileImage} alt="profile" />
         
          {isEditMode && (
            <input
            className='changedp'
              type="file"
              accept="image/*"
              onChange={handleImageChange}
            />
          )}
        </div>
        
        <div className="pcontainer">
          {isEditMode ? (
            <form onSubmit={handleSubmit}>
              <div className="form-group">
                <label>
                  <strong>Name:</strong><br></br>
                  <input
                    type="text"
                    name="firstName"
                    value={editedData.firstName}
                    onChange={handleInputChange}
                  />
                </label>
              </div>
              <div className="form-group">
                <label>
                  <strong>Email:</strong><br></br>
                  <input
                    type="email"
                    name="email"
                    value={editedData.email}
                    onChange={handleInputChange}
                  />
                </label>
              </div>
              <div className='form-group'>
                <label>
                  <strong>Gender:</strong><br></br>
                  <input 
                    type="text"
                    name="gender"
                    value={editedData.gender}
                    onChange={handleInputChange}
                  />
                </label>
              </div>
              <div className="form-group">
                <label>
                  <strong>Age :</strong><br></br>
                  <input
                    type="number"
                    name="age"
                    value={editedData.age}
                    onChange={handleInputChange}
                  />
                </label>
              </div>
              <div className="btn-group">
                <button className="btn" type="submit">Save</button>
                <button className="btn" onClick={() => setIsEditMode(false)}>Cancel</button>
              </div>
            </form>
          ) : (
            <div>
              <p className='pro'>
                <strong>Name:</strong><br></br> {userData.firstName}
              </p>
              <p className='pro1'>
                <strong>Email:</strong> {userData.email}
              </p>
              <p className='pro2'>
                <strong>Gender:</strong> {userData.gender}
              </p>
              <p className='pro3'>
                <strong>Age:</strong> {userData.age}
              </p>
              <button className="btn" onClick={() => setIsEditMode(true)}>Edit</button>
            </div>
          )}
        </div>
      </div>
    </>
  );
}

export default ProfilePage;