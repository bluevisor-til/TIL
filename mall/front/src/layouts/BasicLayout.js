import BasicMenu from "../components/menus/BasicMenu";

const BasicLayout = ({ children }) => {
  // { children } 으로 자신이 출력해야 하는 다른 내용물을 전달 받고 div 내에 이것을 이용함
  return (
    <>
      <BasicMenu></BasicMenu>
      <div
        className={
          "bg-white my-5 w-full flex flex-col space-y-4 md:flex-row md:space-x-4 md:space-y-0"
        }
      >
        <main className={"bg-sky-300 md:w-2/3 lg:w-3/4 px-5 py-40"}>
          {children}
        </main>
        <aside className={"bg-green-300 md:w-1/3 lg:w-1/4 px-5 py-40"}>
          <h1>Sidebar</h1>
        </aside>
      </div>
    </>
  );
};

export default BasicLayout;
