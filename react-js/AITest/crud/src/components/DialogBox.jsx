
const DialogBox = ({ isOpen, title, children, onClose }) => {
    if (!isOpen) return null;

    return (
        <dialog open>
            <h2>{title}</h2>
            {children}
            <hr />
            <div>
                <button type="button" className="btnClose" onClick={onClose}>Close</button>
            </div>
        </dialog>
    );
};

export default DialogBox;