import "./navigation.css";
import { Link } from "react-router-dom";

function Navigation(pros) {
  return (
    <nav>
      <ul class="navigation-box header-content">
        <li className=" nav-item">
          <Link to="/login" className="link header-3">
            save more on app
          </Link>
        </li>
        <li className=" nav-item">
          <Link to="/login" className="link header-3">
            sell on lazada
          </Link>
        </li>
        <li className=" nav-item">
          <Link to="/login" className="link header-3">
            customer care
          </Link>
        </li>
        <li className=" nav-item">
          <Link to="/login" className="link header-3">
            track my order
          </Link>
        </li>
        <li className=" nav-item">
          <Link to="/login" className="link header-3">
            login{" "}
          </Link>
        </li>
        <li class="nav-item">
          <Link to="/signup" className="link header-3">
            sign up
          </Link>
        </li>
      </ul>
    </nav>
  );
}

export default Navigation;
