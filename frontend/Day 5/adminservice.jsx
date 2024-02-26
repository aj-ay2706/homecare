import  { useState } from "react";
import "../../assets/css/service.css";
import Sidebar from "../../components/sidebar";
import "../../assets/css/adminservice.css";

function AdminService() {
    const [cards, setCards] = useState([
        { id: 1, image: "https://res.cloudinary.com/dd5l5ltp8/image/upload/v1708713371/logan-weaver-lgnwvr-lK0l9pzxLps-unsplash_gto54q.jpg", text: "Text for card 1" },
        { id: 2, image: "https://res.cloudinary.com/dd5l5ltp8/image/upload/v1708713366/brooke-lark-lcZ9NxhOSlo-unsplash_qd7mtl.jpg", text: "Text for card 2" },
        { id: 3, image: "https://res.cloudinary.com/dd5l5ltp8/image/upload/v1708713366/mockup-graphics-i1iqQRLULlg-unsplash_gaiptu.jpg", text: "Text for card 3" },
        { id: 4, image: "https://res.cloudinary.com/dd5l5ltp8/image/upload/v1708359457/homecare/rgiayvb7tix281rexstd.jpg", text: "Text for card 4" }
    ]);

    const [editedText, setEditedText] = useState("");
    const [editedImage, setEditedImage] = useState("");
    const [editCardId, setEditCardId] = useState(null);

    const handleDelete = (id) => {
        setCards(cards.filter((card) => card.id !== id));
    };

    const handleEditText = (id, newText) => {
        setEditedText(newText);
    };

    const handleEditImage = (id, newImage) => {
        setEditedImage(newImage);
    };

    const handleSave = (id) => {
        setCards(cards.map((card) => {
            if (card.id === id) {
                return { ...card, text: editedText, image: editedImage };
            }
            return card;
        }));
        setEditCardId(null);
        setEditedText("");
        setEditedImage("");
    };

    const handleEdit = (id) => {
        setEditCardId(id);
        setEditedText(cards.find(card => card.id === id).text);
        setEditedImage(cards.find(card => card.id === id).image);
    };
    
    return (
        <>
            <Sidebar />
            <div style={{marginLeft:"10%"}}>
            {cards.map((card) => (
                <div className="scard" key={card.id} style={{width:"20%"}}>
                    <img src={card.image} alt={"Image " + card.id} />
                    {editCardId === card.id ? (
                        <>
                            <input
                                type="text"
                                value={editedText}
                                onChange={(e) => handleEditText(card.id, e.target.value)}
                                style={{marginTop:"20px",marginBottom:"20px"}}
                            />
                            <input
                                type="file"
                                onChange={(e) => {
                                    const file = e.target.files[0];
                                    const reader = new FileReader();
                                    reader.onloadend = () => {
                                        handleEditImage(card.id, reader.result);
                                    };
                                    if (file) {
                                        reader.readAsDataURL(file);
                                    }
                                }}
                                style={{marginBottom:"20px",marginLeft:"20px"}}
                            />
                            <button className="sbutton" onClick={() => handleSave(card.id)}>Save</button>
                        </>
                    ) : (
                        <p>{card.text}</p>
                    )}
                    <div className="card-buttons">
                        <button className="sbutton" onClick={() => handleEdit(card.id)}>Edit</button>
                        <button className="sbutton" onClick={() => handleDelete(card.id)}>Delete</button>
                    </div>
                </div>
            ))}
            </div>
        </>
    );
}

export default AdminService;
