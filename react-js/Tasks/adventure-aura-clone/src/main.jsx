import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { RouterProvider } from 'react-router-dom'
import { routes } from './Routing/Routings.jsx'
import MyErrorPage from './pages/MyErrorPage.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={routes}>
      errorElement={<MyErrorPage />}
    </RouterProvider>
  </StrictMode>,
)