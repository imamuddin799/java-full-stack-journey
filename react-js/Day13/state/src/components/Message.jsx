import { Component } from "react"; 
import silentbell from "../assets/images/silentbell.png"
import bellicon from "../assets/images/bellicon.png"

class Message extends Component{
    constructor() {
        super()
        this.state = {
            message: "Welcome Visitor",
            subscribe: false,
            imageUrl: silentbell
        };
    }

    changeMessage = () => {
        this.setState({
            message: "Thanks for subscribing the page 🙏 and please press the bell icon",
            subscribe: true
        });
    }

    pressBellIcon = () => {
        this.setState({
            message: "You will get latest update",
            imageUrl:bellicon
        })
    }

    render() {
        console.log(this.state);
        console.log("Component will be re-render when state changes");
        return (
            <>
                <h1>{this.state.message}</h1>
                {
                    this.state.subscribe == false ? (<button onClick={this.changeMessage}>Subscribe</button>) : (<img src={this.state.imageUrl} alt="" onClick={this.pressBellIcon} />)
                }
            </>
        );
    }
}

export default Message;