import ExternalCSS from "./components/ExternalCSS";
import InlineCSS from "./components/InlineCSS"
import InternalCSS from "./components/InternalCSS";
import ModuleCSS from "./components/ModuleCSS";

let App = () => {

  return <>
    <InlineCSS />
    <InternalCSS />
    <ExternalCSS />
    <ModuleCSS />
  </>
}
export default App;