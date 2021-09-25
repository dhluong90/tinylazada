import "./text-field.css";

export default function TextField(props) {
  return (
    <div className="input-group">
      <p className="input-label">{props.label}</p>
      <input
        className="text-field"
        type={props.type}
        name={props.name}
        placeholder={props.placeholder}
      />
    </div>
  );
}
