import ComponentE from "./components/children_props/ComponentE"
import ParentProps from "./components/ParentProps"
import ComponentA from "./components/props_drilling/ComponentA"


function App() {
  return <>
    <ParentProps />
    <ComponentA />
    <ComponentE />
  </>
}

export default App