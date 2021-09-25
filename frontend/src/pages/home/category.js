import React from "react";
import "./category.css";
class Category extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      Categories: [
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/0458c89f3d0a43ba233c6d9e3727a79a.jpg_170x170Q100.jpg_.webp",
          name: "Toilet Papers",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
        {
          icon: "https://sg-test-11.slatic.net/p/519458f391bda8749f2d06a7f15d4bdc.jpg_170x170Q100.jpg_.webp",
          name: "Monitors",
        },
      ],
    };
  }
  render() {
    const listCards = this.state.Categories.map((category, index) => (
      <div className="category-card" key={index}>
        <img src={category.icon} aria-label="category icon" />
        <p>{category.name}</p>
      </div>
    ));
    return (
      <div className="category-section header-content home-page-section">
        <h1 className="first-header">Categories</h1>
        <div className="category-list">{listCards}</div>
      </div>
    );
  }
}

export default Category;
