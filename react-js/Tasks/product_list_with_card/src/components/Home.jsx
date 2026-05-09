
// import { Fragment, useState } from 'react'
// import cartIcon from '../assets/images/icon-add-to-cart.svg'
// import jsondata from './img.json'
// import { RxCrossCircled } from "react-icons/rx";
// import tree from '../assets/images/icon-carbon-neutral.svg'
// import empty from '../assets/images/illustration-empty-cart.svg'
// import confirmed from '../assets/images/icon-order-confirmed.svg'
// import { CiCirclePlus } from "react-icons/ci";
// import { CiCircleMinus } from "react-icons/ci";

// let Home = () => {

//     let [cartItems, setCartItems] = useState([]);
//     let [cartCount, setCartCount] = useState(0);
//     let [cartTotal, setCartTotal] = useState(0);
//     let [isClickedConfirmOrder, setIsClickedConfirmOrder] = useState(false)

//     let handleAddToCart = (item) => {
//         setCartCount(cartCount + 1);
//         setCartItems(prevItems => {
//             let existingItemIndex = prevItems.findIndex(i => i.name === item.name);
//             if (existingItemIndex !== -1) {
//                 let updatedItems = [...prevItems];
//                 updatedItems[existingItemIndex].quantity += 1;
//                 setCartTotal(cartTotal + item.price);
//                 return updatedItems;
//             }
//             else {
//                 setCartTotal(cartTotal + item.price);
//                 return [...prevItems, { ...item, quantity: 1 }];
//             }
//         })
//     }

//     let handleRemoveFromCart = (item) => {
//         // ! Not a good practice
//         // setCartCount(cartCount - 1)
//         // setCartTotal(cartTotal - item.price);

//         // ! Good practice
//         setCartCount(prev => prev - 1);
//         setCartTotal(prev => prev - item.price);

//         setCartItems(prevItems => {
//             let existingItemIndex = prevItems.findIndex(i => i.name === item.name)
//             let updatedItems = [...prevItems]
//             let updatedItem = { ...updatedItems[existingItemIndex] }

//             if (updatedItem.quantity > 1) {
//                 updatedItem.quantity -= 1;
//                 updatedItems[existingItemIndex] = updatedItem;
//             } else {
//                 updatedItems.splice(existingItemIndex, 1);
//             }
//             return updatedItems;
//         })
//     }

//     let handleDeleteFromCart = (item) => {
//         setCartCount(cartCount - item.quantity);
//         setCartTotal(cartTotal - (item.quantity * item.price));
//         setCartItems(prevItems => {
//             let remainingItems = prevItems.filter((prevItem) => {
//                 return prevItem.name !== item.name
//             })
//             return remainingItems;
//         })
//     }

//     let handleCloseDialog = () => {
//         setIsClickedConfirmOrder(false)
//     }

//     let handleConfirmClick = () => {
//         setIsClickedConfirmOrder(true)
//     }

//     let handleStartNewOrder = () => {
//         setCartCount(0);
//         setCartTotal(0);
//         setCartItems([]);
//         handleCloseDialog();
//     }

//     return <>
//         <main style={{ padding: "100px", backgroundColor: "#ddd" }}>
//             <section style={{ width: "100%", height: "100%", display: "flex" }}>
//                 <aside style={{ width: "70%" }}>
//                     <h1 style={{ paddingBottom: "10px", fontSize: "32px" }}>Desserts</h1>
//                     <div style={{ display: "grid", gridTemplateColumns: `repeat(auto-fit, 280px)`, justifyContent: "space-between", gap: "20px" }}>
//                         {
//                             jsondata.map((itemDetails, index) => {
//                                 let { url, name, heading, price } = itemDetails;
//                                 let addedItemIndex = cartItems.findIndex(i => i.name == name)
//                                 addedItemIndex != -1 ? itemDetails = cartItems[addedItemIndex] : itemDetails;
//                                 return <Fragment key={index}>
//                                     <div>
//                                         {
//                                             addedItemIndex != -1 ? (
//                                                 <>
//                                                     <img src={url} alt="" style={{ width: "100%", borderRadius: "14px", border: "3px solid orangered" }} />
//                                                     <div style={{ position: 'relative', top: '-22px', display: 'flex', justifyContent: "center" }}>
//                                                         <div style={{ padding: "8px 10px", borderRadius: "17px 17px 17px 17px", display: 'flex', justifyContent: "space-between", alignItems: "center", border: "0.5px solid #33333344", backgroundColor: "orangered", color: "white", fontWeight: "500" }}>
//                                                             <CiCirclePlus onClick={() => { handleAddToCart(itemDetails) }} style={{ marginRight: "20px" }} />
//                                                             {itemDetails.quantity}
//                                                             <CiCircleMinus onClick={() => {handleRemoveFromCart(itemDetails)}} style={{ marginLeft: "20px" }} />
//                                                         </div>
//                                                     </div>
//                                                 </>
//                                             ) : (
//                                                 <>
//                                                     <img src={url} alt="" style={{ width: "100%", borderRadius: "14px" }} />
//                                                     <div style={{ position: 'relative', top: '-22px', display: 'flex', justifyContent: "center" }}>
//                                                         <button type='button' onClick={() => { handleAddToCart(itemDetails) }} style={{ padding: "8px 30px", borderRadius: "17px 17px 17px 17px", display: 'flex', justifyContent: "center", alignItems: "center", border: "0.5px solid #33333344" }}>
//                                                             <img src={cartIcon} alt="" style={{ width: "19px", marginRight: "10px" }} />
//                                                             <span style={{ fontWeight: "bold" }}>Add to Cart</span>
//                                                         </button>
//                                                     </div>
//                                                 </>
//                                             )
//                                         }
//                                         <p style={{ marginTop: "-20px", fontSize: "14px", color: "gray" }}>{name}</p>
//                                         <h3>{heading}</h3>
//                                         <h2 style={{ fontSize: "18px", color: "#c66b5a" }}>${price.toFixed(2)}</h2>
//                                     </div>
//                                 </Fragment>
//                             })
//                         }
//                     </div>
//                 </aside>
//                 <aside style={{ width: "30%" }}>
//                     <div style={{ margin: "0px 30px", backgroundColor: "#fff", padding: "20px", borderRadius: "10px" }}>
//                         <h1>Your Cart ({cartCount})</h1>
//                         {cartItems.length == 0 ? (
//                             <div style={{ display: "flex", flexDirection: "column", justifyContent: "center", alignItems: "center" }}>
//                                 <img src={empty} alt="" />
//                                 <p>Your added items will appear here</p>
//                             </div>
//                         ) : (
//                             <div>
//                                 <div>
//                                     {
//                                         cartItems.map((item, index) => {
//                                             let { name, quantity, price } = item;
//                                             return <Fragment key={index}>
//                                                 <div style={{ borderBottom: "1px solid #55555555", padding: "8px 0px", display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: "10px" }}>
//                                                     <div>
//                                                         <h5>{name}</h5>
//                                                         <p><span style={{ padding: "4px 10px 4px 0px", color: "orangered", fontSize: "12px" }}>{quantity}x</span><span style={{ padding: "4px 10px 4px 0px", fontSize: "12px" }}>@ ${price.toFixed(2)}</span><span style={{ padding: "4px 10px 4px 0px", fontSize: "12px" }}>${(price * quantity).toFixed(2)}</span></p>
//                                                     </div>
//                                                     <button type='button' onClick={() => handleDeleteFromCart(item)} style={{ backgroundColor: "transparent", border: "0px solid", paddingLeft: "20px" }}><RxCrossCircled /></button>
//                                                 </div>
//                                             </Fragment>
//                                         })
//                                     }
//                                     <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", padding: "25px 0px" }}>
//                                         <p style={{ fontSize: "13px" }}>Order Total</p>
//                                         <h1 style={{ fontSize: "22px" }}>${cartTotal}</h1>
//                                     </div>
//                                     <div style={{ display: "flex", justifyContent: "center", alignItems: "center", backgroundColor: "#ddd", padding: "10px 0px", borderRadius: "10px" }}>
//                                         <img src={tree} alt="" />
//                                         <p style={{ fontSize: "13px", paddingLeft: "10px" }}>This is a <span style={{ fontWeight: "bolder" }}>carbon-neutral</span> delivery</p>
//                                     </div>
//                                     <button type='button' onClick={handleConfirmClick} style={{ backgroundColor: "orangered", color: "white", width: "100%", marginTop: "15px", padding: "10px 0px", border: "0px solid", borderRadius: '10px' }}>Confirm Order</button>
//                                 </div>
//                             </div>
//                         )}
//                     </div>
//                 </aside>
//             </section>
//             {
//                 isClickedConfirmOrder && (
//                     <dialog open style={{ position: "fixed", top: "0", left: "0", width: "100%", height: "100%", backgroundColor: "#00000088", overflowY: "scroll", border: "none", padding: "0", margin: "0", display: "flex", justifyContent: "center", alignItems: "center" }}>
//                         <div style={{ width: "calc(30% - 100px)", background: "#fff", padding: "20px", borderRadius: "10px" }}>
//                             <img src={confirmed} alt="" />
//                             <h1>Order Confirmed</h1>
//                             <p style={{ marginBottom: "20px", fontSize: "14px", color: "gray" }}>We hope you enjoy your food!</p>
//                             <div style={{ backgroundColor: "#eee", padding: "10px", borderRadius: "5px" }}>
//                                 {
//                                     cartItems.map((item, index) => {
//                                         let { name, quantity, price, url } = item;
//                                         return <Fragment key={index}>
//                                             <div style={{ borderBottom: "1px solid #55555555", padding: "8px 0px", display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: "10px" }}>
//                                                 <div style={{ display: "flex", gap: "10px", justifyContent: "center", alignItems: "center" }}>
//                                                     <img src={url} alt="" style={{ width: "40px", borderRadius: "4px" }} />
//                                                     <div>
//                                                         <h5>{name}</h5>
//                                                         <p><span style={{ padding: "4px 10px 4px 0px", color: "orangered", fontSize: "12px" }}>{quantity}x</span><span style={{ padding: "4px 10px 4px 0px", fontSize: "12px" }}>@ ${price.toFixed(2)}</span></p>
//                                                     </div>
//                                                 </div>
//                                                 <p style={{ fontSize: "13px", fontWeight: "700" }}>${(price * quantity).toFixed(2)}</p>
//                                             </div>
//                                         </Fragment>
//                                     })
//                                 }
//                                 <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", padding: "15px 0px" }}>
//                                     <p style={{ fontSize: "13px" }}>Order Total</p>
//                                     <h1 style={{ fontSize: "22px" }}>${cartTotal}</h1>
//                                 </div>
//                             </div>
//                             <button type='button' onClick={handleStartNewOrder} style={{ backgroundColor: "orangered", color: "white", width: "100%", marginTop: "15px", padding: "10px 0px", border: "0px solid", borderRadius: '10px' }}>Start New Order</button>
//                         </div>
//                     </dialog>
//                 )
//             }
//         </main>
//     </>
// }
// export default Home;




import { Fragment, useMemo, useState } from "react";
import cartIcon from "../assets/images/icon-add-to-cart.svg";
import jsondata from "./img.json";
import { RxCrossCircled } from "react-icons/rx";
import tree from "../assets/images/icon-carbon-neutral.svg";
import empty from "../assets/images/illustration-empty-cart.svg";
import confirmed from "../assets/images/icon-order-confirmed.svg";
import { CiCirclePlus, CiCircleMinus } from "react-icons/ci";

const Home = () => {
    const [cartItems, setCartItems] = useState([]);
    const [isOrderConfirmed, setIsOrderConfirmed] = useState(false);

    // Derive cart count and total from cartItems.
    const cartCount = useMemo(
        () => cartItems.reduce((acc, item) => acc + item.quantity, 0),
        [cartItems]
    );
    const cartTotal = useMemo(
        () => cartItems.reduce((acc, item) => acc + item.price * item.quantity, 0),
        [cartItems]
    );

    const handleAddToCart = (item) => {
        setCartItems((prevItems) => {
            const index = prevItems.findIndex((i) => i.name === item.name);
            if (index !== -1) {
                const updated = [...prevItems];
                updated[index] = {
                    ...updated[index],
                    quantity: updated[index].quantity + 1,
                };
                return updated;
            }
            return [...prevItems, { ...item, quantity: 1 }];
        });
    };

    const handleRemoveFromCart = (item) => {
        setCartItems((prevItems) => {
            const index = prevItems.findIndex((i) => i.name === item.name);
            if (index === -1) return prevItems;
            const updated = [...prevItems];
            if (updated[index].quantity > 1) {
                updated[index] = { ...updated[index], quantity: updated[index].quantity - 1 };
            } else {
                updated.splice(index, 1);
            }
            return updated;
        });
    };

    const handleDeleteFromCart = (item) => {
        setCartItems((prevItems) => prevItems.filter((i) => i.name !== item.name));
    };

    const handleConfirmOrder = () => setIsOrderConfirmed(true);
    const handleCloseDialog = () => setIsOrderConfirmed(false);
    const handleStartNewOrder = () => {
        setCartItems([]);
        handleCloseDialog();
    };

    return (
        <main style={{ padding: "100px", backgroundColor: "#ddd" }}>
            <section style={{ display: "flex", width: "100%", height: "100%" }}>
                {/* Desserts Section */}
                <aside style={{ width: "70%" }}>
                    <h1 style={{ paddingBottom: "10px", fontSize: "32px" }}>Desserts</h1>
                    <div
                        style={{
                            display: "grid",
                            gridTemplateColumns: `repeat(auto-fit, 280px)`,
                            gap: "20px",
                            justifyContent: "space-between",
                        }}
                    >
                        {jsondata.map((item, index) => {
                            const { url, name, heading, price } = item;
                            const cartItem = cartItems.find((ci) => ci.name === name);
                            return (
                                <Fragment key={index}>
                                    <div>
                                        {cartItem ? (
                                            <>
                                                <img
                                                    src={url}
                                                    alt={name}
                                                    style={{ width: "100%", borderRadius: "14px", border: "3px solid orangered" }}
                                                />
                                                <div style={{ position: "relative", top: "-22px", display: "flex", justifyContent: "center" }}>
                                                    <div
                                                        style={{
                                                            padding: "8px 10px",
                                                            borderRadius: "17px",
                                                            display: "flex",
                                                            justifyContent: "space-between",
                                                            alignItems: "center",
                                                            border: "0.5px solid #33333344",
                                                            backgroundColor: "orangered",
                                                            color: "white",
                                                            fontWeight: "500",
                                                        }}
                                                    >
                                                        <CiCirclePlus onClick={() => handleAddToCart(item)} style={{ marginRight: "20px", cursor: "pointer" }} />
                                                        {cartItem.quantity}
                                                        <CiCircleMinus onClick={() => handleRemoveFromCart(item)} style={{ marginLeft: "20px", cursor: "pointer" }} />
                                                    </div>
                                                </div>
                                            </>
                                        ) : (
                                            <>
                                                <img src={url} alt={name} style={{ width: "100%", borderRadius: "14px" }} />
                                                <div style={{ position: "relative", top: "-22px", display: "flex", justifyContent: "center" }}>
                                                    <button
                                                        type="button"
                                                        onClick={() => handleAddToCart(item)}
                                                        style={{
                                                            padding: "8px 30px",
                                                            borderRadius: "17px",
                                                            display: "flex",
                                                            justifyContent: "center",
                                                            alignItems: "center",
                                                            border: "0.5px solid #33333344",
                                                            cursor: "pointer",
                                                        }}
                                                    >
                                                        <img src={cartIcon} alt="cart icon" style={{ width: "19px", marginRight: "10px" }} />
                                                        <span style={{ fontWeight: "bold" }}>Add to Cart</span>
                                                    </button>
                                                </div>
                                            </>
                                        )}
                                        <p style={{ marginTop: "-20px", fontSize: "14px", color: "gray" }}>{name}</p>
                                        <h3>{heading}</h3>
                                        <h2 style={{ fontSize: "18px", color: "#c66b5a" }}>${price.toFixed(2)}</h2>
                                    </div>
                                </Fragment>
                            );
                        })}
                    </div>
                </aside>

                {/* Cart Section */}
                <aside style={{ width: "30%" }}>
                    <div style={{ margin: "0 30px", backgroundColor: "#fff", padding: "20px", borderRadius: "10px" }}>
                        <h1>Your Cart ({cartCount})</h1>
                        {cartItems.length === 0 ? (
                            <div style={{ display: "flex", flexDirection: "column", justifyContent: "center", alignItems: "center" }}>
                                <img src={empty} alt="empty cart" />
                                <p>Your added items will appear here</p>
                            </div>
                        ) : (
                            <div>
                                {cartItems.map((item, index) => {
                                    const { name, quantity, price } = item;
                                    return (
                                        <Fragment key={index}>
                                            <div
                                                style={{
                                                    borderBottom: "1px solid #55555555",
                                                    padding: "8px 0",
                                                    display: "flex",
                                                    justifyContent: "space-between",
                                                    alignItems: "center",
                                                    marginBottom: "10px",
                                                }}
                                            >
                                                <div>
                                                    <h5>{name}</h5>
                                                    <p>
                                                        <span style={{ padding: "4px 10px 4px 0", color: "orangered", fontSize: "12px" }}>
                                                            {quantity}x
                                                        </span>
                                                        <span style={{ padding: "4px 10px 4px 0", fontSize: "12px" }}>@ ${price.toFixed(2)}</span>
                                                        <span style={{ padding: "4px 10px 4px 0", fontSize: "12px" }}>
                                                            ${(price * quantity).toFixed(2)}
                                                        </span>
                                                    </p>
                                                </div>
                                                <button
                                                    type="button"
                                                    onClick={() => handleDeleteFromCart(item)}
                                                    style={{ backgroundColor: "transparent", border: "none", paddingLeft: "20px", cursor: "pointer" }}
                                                >
                                                    <RxCrossCircled />
                                                </button>
                                            </div>
                                        </Fragment>
                                    );
                                })}
                                <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", padding: "25px 0" }}>
                                    <p style={{ fontSize: "13px" }}>Order Total</p>
                                    <h1 style={{ fontSize: "22px" }}>${cartTotal.toFixed(2)}</h1>
                                </div>
                                <div
                                    style={{
                                        display: "flex",
                                        justifyContent: "center",
                                        alignItems: "center",
                                        backgroundColor: "#ddd",
                                        padding: "10px 0",
                                        borderRadius: "10px",
                                    }}
                                >
                                    <img src={tree} alt="carbon neutral" />
                                    <p style={{ fontSize: "13px", paddingLeft: "10px" }}>
                                        This is a <span style={{ fontWeight: "bolder" }}>carbon-neutral</span> delivery
                                    </p>
                                </div>
                                <button
                                    type="button"
                                    onClick={handleConfirmOrder}
                                    style={{
                                        backgroundColor: "orangered",
                                        color: "white",
                                        width: "100%",
                                        marginTop: "15px",
                                        padding: "10px 0",
                                        border: "none",
                                        borderRadius: "10px",
                                        cursor: "pointer",
                                    }}
                                >
                                    Confirm Order
                                </button>
                            </div>
                        )}
                    </div>
                </aside>
            </section>

            {/* Confirmation Dialog */}
            {isOrderConfirmed && (
                <dialog
                    open
                    style={{
                        position: "fixed",
                        top: 0,
                        left: 0,
                        width: "100%",
                        height: "100%",
                        backgroundColor: "#00000088",
                        overflowY: "scroll",
                        border: "none",
                        padding: 0,
                        margin: 0,
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                    }}
                >
                    <div style={{ width: "calc(30% - 100px)", background: "#fff", padding: "20px", borderRadius: "10px", marginTop: "150px", marginBottom: "50px" }}>
                        <img src={confirmed} alt="order confirmed" />
                        <h1>Order Confirmed</h1>
                        <p style={{ marginBottom: "20px", fontSize: "14px", color: "gray" }}>We hope you enjoy your food!</p>
                        <div style={{ backgroundColor: "#eee", padding: "10px", borderRadius: "5px" }}>
                            {cartItems.map((item, index) => {
                                const { name, quantity, price, url } = item;
                                return (
                                    <Fragment key={index}>
                                        <div
                                            style={{
                                                borderBottom: "1px solid #55555555",
                                                padding: "8px 0",
                                                display: "flex",
                                                justifyContent: "space-between",
                                                alignItems: "center",
                                                marginBottom: "10px",
                                            }}
                                        >
                                            <div style={{ display: "flex", gap: "10px", alignItems: "center" }}>
                                                <img src={url} alt={name} style={{ width: "40px", borderRadius: "4px" }} />
                                                <div>
                                                    <h5>{name}</h5>
                                                    <p>
                                                        <span style={{ padding: "4px 10px 4px 0", color: "orangered", fontSize: "12px" }}>
                                                            {quantity}x
                                                        </span>
                                                        <span style={{ padding: "4px 10px 4px 0", fontSize: "12px" }}>@ ${price.toFixed(2)}</span>
                                                    </p>
                                                </div>
                                            </div>
                                            <p style={{ fontSize: "13px", fontWeight: 700 }}>${(price * quantity).toFixed(2)}</p>
                                        </div>
                                    </Fragment>
                                );
                            })}
                            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", padding: "15px 0" }}>
                                <p style={{ fontSize: "13px" }}>Order Total</p>
                                <h1 style={{ fontSize: "22px" }}>${cartTotal.toFixed(2)}</h1>
                            </div>
                        </div>
                        <button
                            type="button"
                            onClick={handleStartNewOrder}
                            style={{
                                backgroundColor: "orangered",
                                color: "white",
                                width: "100%",
                                marginTop: "15px",
                                padding: "10px 0",
                                border: "none",
                                borderRadius: "10px",
                                cursor: "pointer",
                            }}
                        >
                            Start New Order
                        </button>
                    </div>
                </dialog>
            )}
        </main>
    );
};

export default Home;