import Project from "../Components/Project"

export default function LoginPage() {
    return (
        <form className="login">
            <h1>Login</h1>
            <input type="text" placeholder="username"/>
            <input type="password" placeholder="password"/>
            <button type="submit">Login</button>
        </form>
    )
}