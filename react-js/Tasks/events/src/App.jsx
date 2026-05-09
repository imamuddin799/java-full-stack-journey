import FocusBlurInput from "./components/Day22/multipleevents/FocusBlurInput";
import MouseEventsBox from "./components/Day22/multipleevents/MouseEventsBox";
import HoverBox from "./components/Day22/singleevent/HoverBox";
import InputField from "./components/Day22/singleevent/InputField";

function App() {

  return <>
    {/* single event */}
    <InputField />
    <HoverBox />

    {/* multiple events */}
    <FocusBlurInput />
    <MouseEventsBox />
  </>
}

export default App;
