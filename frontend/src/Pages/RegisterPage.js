import Project from "../Components/Project"

export default function RegisterPage() {
    return (
        <form className="register">
            <h1>Register</h1>
            <input type="text" placeholder="username"/>
            <input type="password" placeholder="password"/>
            <button type="Register">Login</button>
        </form>
    )
}