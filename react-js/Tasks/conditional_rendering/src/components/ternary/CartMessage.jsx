
let CartMessage = () => {

    let items = 5;

    return <p>{items > 0 ? "You have items in cart" : "Your cart is empty"}</p>;
}
export default CartMessage;